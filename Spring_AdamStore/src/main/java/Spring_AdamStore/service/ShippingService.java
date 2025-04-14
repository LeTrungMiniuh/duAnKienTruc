package Spring_AdamStore.service;

import Spring_AdamStore.dto.response.ShippingFeeResponse;

public interface ShippingService {

    ShippingFeeResponse shippingCost(Double totalPrice, String toWardCode, Integer toDistrictId);

}
