package Spring_AdamStore.service;

import Spring_AdamStore.dto.request.OrderRequest;
import Spring_AdamStore.dto.request.PaymentCallbackRequest;
import Spring_AdamStore.dto.request.UpdateOrderAddressRequest;
import Spring_AdamStore.dto.response.OrderResponse;
import Spring_AdamStore.dto.response.PageResponse;
import Spring_AdamStore.dto.response.ShippingFeeResponse;
import Spring_AdamStore.dto.response.VNPayResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface OrderService {

    OrderResponse create(OrderRequest request);

    OrderResponse fetchById(Long id);

    PageResponse<OrderResponse> fetchAll(int pageNo, int pageSize, String sortBy);

    OrderResponse updateAddress(Long id, UpdateOrderAddressRequest request);

    void delete(Long id);

    VNPayResponse processPayment(Long orderId, HttpServletRequest request);

    OrderResponse updateOrderAfterPayment(PaymentCallbackRequest request);

    void handleFailedPayment(PaymentCallbackRequest request);

    VNPayResponse retryPayment(Long orderId, HttpServletRequest request);

    PageResponse<OrderResponse> searchOrder(int pageNo, int pageSize, String sortBy, List<String> search);
}
