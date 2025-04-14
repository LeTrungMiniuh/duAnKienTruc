package Spring_AdamStore.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressRequest {

    Boolean isDefault;

    @NotBlank(message = "streetDetail không được để trống")
    String streetDetail;

    @NotBlank(message = "wardId không được để trống")
    @Min(value = 1, message = "wardId phải lớn hơn 0")
    String wardCode;

    @NotNull(message = "districtId không được để trống")
    @Min(value = 1, message = "districtId phải lớn hơn 0")
    Long districtId;
    @NotNull(message = "provinceId không được để trống")
    @Min(value = 1, message = "provinceId phải lớn hơn 0")
    Long provinceId;
}
