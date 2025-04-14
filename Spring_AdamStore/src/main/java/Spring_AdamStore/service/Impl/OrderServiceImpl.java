package Spring_AdamStore.service.Impl;

import Spring_AdamStore.config.VNPAYConfig;
import Spring_AdamStore.constants.OrderStatus;
import Spring_AdamStore.constants.PaymentMethod;
import Spring_AdamStore.constants.PaymentStatus;
import Spring_AdamStore.constants.RoleEnum;
import Spring_AdamStore.dto.request.*;
import Spring_AdamStore.dto.response.*;
import Spring_AdamStore.entity.*;
import Spring_AdamStore.entity.relationship.PromotionUsage;
import Spring_AdamStore.exception.AppException;
import Spring_AdamStore.exception.ErrorCode;
import Spring_AdamStore.mapper.OrderMapper;
import Spring_AdamStore.repository.*;
import Spring_AdamStore.repository.criteria.SearchCriteriaQueryConsumer;
import Spring_AdamStore.repository.criteria.SearchCriteria;
import Spring_AdamStore.repository.relationship.PromotionUsageRepository;
import Spring_AdamStore.service.CurrentUserService;
import Spring_AdamStore.service.OrderService;
import Spring_AdamStore.service.PageableService;
import Spring_AdamStore.service.relationship.PromotionUsageService;
import Spring_AdamStore.service.relationship.UserHasRoleService;
import Spring_AdamStore.util.VNPayUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Spring_AdamStore.constants.OrderStatus.PENDING;

@Service
@Slf4j(topic = "ORDER-SERVICE")
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    private final CurrentUserService currentUserService;
    private final AddressRepository addressRepository;
    private final ProductVariantRepository productVariantRepository;
    private final OrderItemRepository orderItemRepository;
    private final PromotionRepository promotionRepository;
    private final PaymentHistoryRepository paymentHistoryRepository;
    private final UserHasRoleService userHasRoleService;
    private final VNPAYConfig vnPayConfig;
    private final PageableService pageableService;
    private final PromotionUsageService promotionUsageService;
    private final PromotionUsageRepository promotionUsageRepository;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public OrderResponse create(OrderRequest request) {
        // user
        User user = currentUserService.getCurrentUser();

        // address
        Address address = addressRepository.findById(request.getAddressId())
                .orElseThrow(() -> new AppException(ErrorCode.ADDRESS_NOT_EXISTED));

        Order order = Order.builder()
                .user(user)
                .address(address)
                .orderStatus(PENDING)
                .totalPrice(0.0)
                .orderDate(LocalDate.now())
                .build();

        orderRepository.save(order);

        // orderItem
        Set<OrderItem> orderItemSet = new HashSet<>();
        double totalPrice = request.getShippingFee();
        for(OrderItemRequest orderItemRequest : request.getOrderItems()){
            ProductVariant productVariant = productVariantRepository.findById(orderItemRequest.getProductVariantId())
                    .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_VARIANT_NOT_EXISTED));

            // check sl hang con
            if (productVariant.getQuantity() < orderItemRequest.getQuantity()) {
                throw new AppException(ErrorCode.OUT_OF_STOCK);
            }

            OrderItem orderItem = OrderItem.builder()
                    .quantity(orderItemRequest.getQuantity())
                    .unitPrice(productVariant.getPrice())
                    .order(order)
                    .productVariant(productVariant)
                    .build();

            // tru so luong hang trong kho
            productVariant.setQuantity(productVariant.getQuantity() - orderItemRequest.getQuantity());
            productVariantRepository.save(productVariant);

            orderItemSet.add(orderItem);
            totalPrice += orderItem.getQuantity() * orderItem.getUnitPrice();
        }
        orderItemRepository.saveAll(orderItemSet);
        order.setOrderItems(orderItemSet);

        // Promotion
        if(request.getPromotionId() != null){
            Promotion promotion =  promotionRepository.findById(request.getPromotionId())
                    .orElseThrow(() -> new AppException(ErrorCode.PROMOTION_NOT_EXISTED));

            PromotionUsage promotionUsage = promotionUsageService.applyPromotion(promotion, order, user);

            totalPrice -= promotionUsage.getDiscountAmount();
            order.setPromotionUsage(promotionUsage);
        }

        order.setTotalPrice(totalPrice);

        paymentHistoryRepository.save(PaymentHistory.builder()
                .isPrimary(false)
                .paymentMethod(request.getPaymentMethod())
                .totalAmount(order.getTotalPrice())
                .paymentStatus(PaymentStatus.PENDING)
                .paymentTime(LocalDateTime.now())
                .order(order)
                .build());

        if (request.getPaymentMethod() == PaymentMethod.CASH) {
            order.setOrderStatus(OrderStatus.PROCESSING);
        }

        return orderMapper.toOrderResponse(orderRepository.save(order));
    }

    @Override
    public OrderResponse fetchById(Long id) {
        Order order = findOrderById(id);

        return orderMapper.toOrderResponse(order);
    }

    @Override
    public PageResponse<OrderResponse> fetchAll(int pageNo, int pageSize, String sortBy) {
        pageNo = pageNo - 1;

        Pageable pageable = pageableService.createPageable(pageNo, pageSize, sortBy, Order.class);

        Page<Order> orderPage = orderRepository.findAll(pageable);

        return PageResponse.<OrderResponse>builder()
                .page(orderPage.getNumber() + 1)
                .size(orderPage.getSize())
                .totalPages(orderPage.getTotalPages())
                .totalItems(orderPage.getTotalElements())
                .items(orderMapper.toOrderResponseList(orderPage.getContent()))
                .build();
    }

    @Override
    public PageResponse<OrderResponse> searchOrder(int pageNo, int pageSize, String sortBy, List<String> search) {
        pageNo = pageNo - 1;

        List<SearchCriteria> criteriaList = new ArrayList<>();

        // Lay danh sach dieu kien
        if(search != null){
            for(String s : search){
                Pattern pattern = Pattern.compile("(\\w+?)(~|>|<)(.*)");
                Matcher matcher = pattern.matcher(s);
                if(matcher.find()){
                    criteriaList.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
                }
            }
        }
        List<Order> orderList = getOrderList(pageNo, pageSize, sortBy, criteriaList);

        Long totalElements = getTotalElements(criteriaList);
        int totalPages = (int) Math.ceil((double) totalElements / pageSize);

        return PageResponse.<OrderResponse>builder()
                .page(pageNo + 1)
                .size(pageSize)
                .totalPages(totalPages)
                .totalItems(totalElements)
                .items(orderMapper.toOrderResponseList(orderList))
                .build();
    }

    private List<Order> getOrderList(int pageNo, int pageSize, String sortBy, List<SearchCriteria> criteriaList) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> query = builder.createQuery(Order.class);
        Root<Order> root = query.from(Order.class);

        // xu ly dieu kien
        Predicate predicate = builder.conjunction();

        // check user
        User currentUser = currentUserService.getCurrentUser();
        boolean isAdmin = userHasRoleService.checkRoleForUser(currentUser, RoleEnum.ADMIN);
        if(!isAdmin){
            predicate = builder.and(predicate, builder.equal(root.get("user").get("id"), currentUser.getId()));
        }

        // search
        if(!CollectionUtils.isEmpty(criteriaList)){
            SearchCriteriaQueryConsumer queryConsumer = new SearchCriteriaQueryConsumer(builder, predicate, root);
            criteriaList.forEach(queryConsumer);

            predicate = builder.and(predicate, queryConsumer.getPredicate());
        }

        query.where(predicate);

        // Sort
        if(StringUtils.hasLength(sortBy)){
            Pattern pattern = Pattern.compile("(\\w+?)(-)(asc|desc)");
            Matcher matcher = pattern.matcher(sortBy);
            if(matcher.find()){
                String columnName = matcher.group(1);

                if(matcher.group(3).equalsIgnoreCase("desc")){
                    query.orderBy(builder.desc(root.get(columnName)));
                }else{
                    query.orderBy(builder.asc(root.get(columnName)));
                }
            }
        }

        return entityManager.createQuery(query)
                .setFirstResult(pageNo * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    private Long getTotalElements(List<SearchCriteria> criteriaList) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
        Root<Order> root = countQuery.from(Order.class);

        // Xu ly dieu kien tim kiem
        Predicate predicate = builder.conjunction();

        // search
        if(!CollectionUtils.isEmpty(criteriaList)){
            SearchCriteriaQueryConsumer queryConsumer = new SearchCriteriaQueryConsumer(builder, predicate, root);
            criteriaList.forEach(queryConsumer);

            predicate = builder.and(predicate, queryConsumer.getPredicate());
        }

        countQuery.select(builder.count(root));
        countQuery.where(predicate);

        return entityManager.createQuery(countQuery).getSingleResult();
    }

    @Override
    public OrderResponse updateAddress(Long id, UpdateOrderAddressRequest request) {
        Order order = findOrderById(id);

        String currentUserEmail = currentUserService.getCurrentUsername();

        if (!order.getUser().getEmail().equals(currentUserEmail)) {
            throw new AppException(ErrorCode.ORDER_NOT_BELONG_TO_USER);
        }

        if (!(order.getOrderStatus() == OrderStatus.PENDING || order.getOrderStatus() == OrderStatus.PROCESSING)) {
            throw new AppException(ErrorCode.ORDER_CANNOT_UPDATE_ADDRESS);
        }

        Address newAddress = addressRepository.findById(request.getAddressId())
                .orElseThrow(() -> new AppException(ErrorCode.ADDRESS_NOT_EXISTED));

        if (!newAddress.getUser().getEmail().equals(currentUserEmail)) {
            throw new AppException(ErrorCode.ADDRESS_NOT_BELONG_TO_USER);
        }

        order.setAddress(newAddress);
        return orderMapper.toOrderResponse(orderRepository.save(order));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Order order = findOrderById(id);

        orderItemRepository.deleteAll(order.getOrderItems());

        paymentHistoryRepository.deleteAll(order.getPayments());

        promotionUsageRepository.delete(order.getPromotionUsage());

        orderRepository.delete(order);
    }

    private Order findOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_EXISTED));
    }


    @Override
    public VNPayResponse processPayment(Long orderId, HttpServletRequest request) {
        Order order = findOrderById(orderId);

        if (!order.getOrderStatus().equals(OrderStatus.PENDING)) {
            throw new AppException(ErrorCode.INVALID_ORDER_STATUS);
        }

        return VNPayResponse.builder()
                .code("OK")
                .message("Mã thanh toán đã được tạo thành công. Bạn sẽ được chuyển đến cổng thanh toán để hoàn tất giao dịch.")
                .paymentUrl(createVnPayPayment(order, request))
                .build();
    }

    public String createVnPayPayment(Order order, HttpServletRequest request) {
        Map<String, String> vnpParamsMap = vnPayConfig.getVNPayConfig();

        long amount = (long) (100 * order.getTotalPrice());

        vnpParamsMap.put("vnp_Amount", String.valueOf(amount));

        vnpParamsMap.put("vnp_IpAddr", VNPayUtil.getIpAddress(request));

        // Tao chuoi da ma hoa
        String queryUrl = VNPayUtil.getPaymentURL(vnpParamsMap, true);

        // Tao chuoi chua ma hoa
        String hashData = VNPayUtil.getPaymentURL(vnpParamsMap, false);
        // Thêm vnp_SecureHash vào URL
        String vnpSecureHash = VNPayUtil.hmacSHA512(vnPayConfig.getSecretKey(), hashData);

        queryUrl += "&vnp_SecureHash=" + vnpSecureHash;

        // Tao URL Final
        return vnPayConfig.getVnp_PayUrl() + "?" + queryUrl;
    }

    @Override
    public OrderResponse updateOrderAfterPayment(PaymentCallbackRequest request) {
        Order order = findOrderById(request.getOrderId());
        order.setOrderStatus(OrderStatus.PROCESSING);

        PaymentHistory  paymentHistory = paymentHistoryRepository.findByOrderIdAndPaymentStatus(order.getId(), PaymentStatus.PENDING)
                .orElseThrow(() -> new AppException(ErrorCode.PAYMENT_HISTORY_NOT_EXISTED));
        paymentHistory.setIsPrimary(true);
        paymentHistory.setPaymentStatus(PaymentStatus.PAID);
        paymentHistory.setPaymentTime(LocalDateTime.now());
        paymentHistoryRepository.save(paymentHistory);

        return orderMapper.toOrderResponse(orderRepository.save(order));
    }

    public void handleFailedPayment(PaymentCallbackRequest request){
        Order order = findOrderById(request.getOrderId());
        PaymentHistory  paymentHistory = paymentHistoryRepository.findByOrderIdAndPaymentStatus(order.getId(), PaymentStatus.PENDING)
                .orElseThrow(() -> new AppException(ErrorCode.PAYMENT_HISTORY_NOT_EXISTED));

        paymentHistory.setPaymentStatus(PaymentStatus.FAILED);
        paymentHistoryRepository.save(paymentHistory);

    }

    @Override
    public VNPayResponse retryPayment(Long orderId, HttpServletRequest request) {
        Order order = findOrderById(orderId);

        if (!order.getOrderStatus().equals(OrderStatus.PENDING)) {
            throw new AppException(ErrorCode.INVALID_ORDER_STATUS);
        }

        String paymentUrl = createVnPayPayment(order, request);

        paymentHistoryRepository.save(PaymentHistory.builder()
                .isPrimary(false)
                .paymentMethod(PaymentMethod.VNPAY)
                .totalAmount(order.getTotalPrice())
                .paymentStatus(PaymentStatus.PENDING)
                .paymentTime(LocalDateTime.now())
                .order(order)
                .build());

        return VNPayResponse.builder()
                .code("OK")
                .message("Mã thanh toán đã được tạo thành công. Bạn sẽ được chuyển đến cổng thanh toán để hoàn tất giao dịch.")
                .paymentUrl(paymentUrl)
                .build();
    }


    @Scheduled(cron = "0 0 0 * * ?")
    public void updateOrderStatusProcessingToShipped() {
        log.info("Update Order From Processing To Shipped");

        LocalDate currentDate = LocalDate.now();

        List<Order> orderList = orderRepository.findByOrderStatusAndOrderDateBefore(OrderStatus.PROCESSING,
                currentDate.minusDays(1));

        orderList.forEach(order ->  order.setOrderStatus(OrderStatus.SHIPPED));
        orderRepository.saveAll(orderList);
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void updateOrderStatusShippedToDelivered() {
        log.info("Update Order From Shipped To Delivered");

        LocalDate currentDate = LocalDate.now();

        List<Order> orderList = orderRepository.findByOrderStatusAndOrderDateBefore(OrderStatus.SHIPPED,
                currentDate.minusDays(5));

        orderList.forEach(order ->  order.setOrderStatus(OrderStatus.DELIVERED));
        orderRepository.saveAll(orderList);

    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void cancelPendingOrdersOverOneDay() {
        log.info("Cancel Pending Orders Over One Day");

        LocalDate currentDate = LocalDate.now();

        List<Order> orderList = orderRepository.findByOrderStatusAndOrderDateBefore(PENDING,
                currentDate.minusDays(1));

        orderList.forEach(order ->  order.setOrderStatus(OrderStatus.CANCELLED));
        orderRepository.saveAll(orderList);

    }

}
