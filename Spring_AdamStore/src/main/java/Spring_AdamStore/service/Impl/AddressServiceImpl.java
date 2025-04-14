package Spring_AdamStore.service.Impl;

import Spring_AdamStore.dto.request.AddressRequest;
import Spring_AdamStore.dto.response.AddressResponse;
import Spring_AdamStore.dto.response.BranchResponse;
import Spring_AdamStore.dto.response.PageResponse;
import Spring_AdamStore.entity.*;
import Spring_AdamStore.exception.AppException;
import Spring_AdamStore.exception.ErrorCode;
import Spring_AdamStore.mapper.AddressMapper;
import Spring_AdamStore.repository.*;
import Spring_AdamStore.service.AddressService;
import Spring_AdamStore.service.AuthService;
import Spring_AdamStore.service.CurrentUserService;
import Spring_AdamStore.service.PageableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j(topic = "ADDRESS-SERVICE")
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final PageableService pageableService;
    private final DistrictRepository districtRepository;
    private final ProvinceRepository provinceRepository;
    private final WardRepository wardRepository;
    private final CurrentUserService currentUserService;
    private final OrderRepository orderRepository;

    @Override
    public AddressResponse create(AddressRequest request) {
        Address address = addressMapper.toAddress(request);

        Ward ward = findWardById(request.getWardCode());

        District district = findDistrictById(request.getDistrictId());

        if (!ward.getDistrict().getId().equals(district.getId())) {
            throw new AppException(ErrorCode.INVALID_DISTRICT_FOR_WARD);
        }

        Province province = findProvinceById(request.getProvinceId());

        if (!district.getProvince().getId().equals(province.getId())) {
            throw new AppException(ErrorCode.INVALID_PROVINCE_FOR_DISTRICT);
        }

        address.setWard(ward);
        address.setProvince(province);
        address.setDistrict(district);

        User user = currentUserService.getCurrentUser();
        address.setUser(user);

        return addressMapper.toAddressResponse(addressRepository.save(address));
    }

    @Override
    public AddressResponse fetchById(Long id) {
        Address address = findAddressById(id);

        return addressMapper.toAddressResponse(address);
    }

    @Override
    public PageResponse<AddressResponse> fetchAll(int pageNo, int pageSize, String sortBy) {
        pageNo = pageNo - 1;

        Pageable pageable = pageableService.createPageable(pageNo, pageSize, sortBy, Address.class);

        Page<Address> addressPage = addressRepository.findAll(pageable);

        return PageResponse.<AddressResponse>builder()
                .page(addressPage.getNumber() + 1)
                .size(addressPage.getSize())
                .totalPages(addressPage.getTotalPages())
                .totalItems(addressPage.getTotalElements())
                .items(addressMapper.toAddressResponseList(addressPage.getContent()))
                .build();
    }

    @Override
    public AddressResponse update(Long id, AddressRequest request) {
        Address address = findAddressById(id);

        addressMapper.update(address, request);

        Ward ward = findWardById(request.getWardCode());

        District district = findDistrictById(request.getDistrictId());

        if (!ward.getDistrict().getId().equals(district.getId())) {
            throw new AppException(ErrorCode.INVALID_DISTRICT_FOR_WARD);
        }

        Province province = findProvinceById(request.getProvinceId());

        if (!district.getProvince().getId().equals(province.getId())) {
            throw new AppException(ErrorCode.INVALID_PROVINCE_FOR_DISTRICT);
        }

        address.setWard(ward);
        address.setProvince(province);
        address.setDistrict(district);

        return addressMapper.toAddressResponse(addressRepository.save(address));
    }

    @Override
    public void delete(Long id) {
        Address address = findAddressById(id);
        address.getOrders().forEach(order -> order.setAddress(null));
        orderRepository.saveAll(address.getOrders());

        addressRepository.delete(address);
    }

    private Address findAddressById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.ADDRESS_NOT_EXISTED));
    }

    private Ward findWardById(String id) {
        return wardRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.WARD_NOT_EXISTED));
    }

    private District findDistrictById(Long id) {
        return districtRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.DISTRICT_NOT_EXISTED));
    }

    private Province findProvinceById(Long id) {
        return provinceRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PROVINCE_NOT_EXISTED));
    }
}


