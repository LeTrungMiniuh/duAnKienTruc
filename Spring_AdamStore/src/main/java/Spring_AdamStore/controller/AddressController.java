package Spring_AdamStore.controller;

import Spring_AdamStore.dto.request.AddressRequest;
import Spring_AdamStore.dto.request.BranchRequest;
import Spring_AdamStore.dto.response.AddressResponse;
import Spring_AdamStore.dto.response.ApiResponse;
import Spring_AdamStore.dto.response.BranchResponse;
import Spring_AdamStore.dto.response.PageResponse;
import Spring_AdamStore.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j(topic = "ADDRESS-CONTROLLER")
@RequiredArgsConstructor
@Validated
@RequestMapping("/v1")
@RestController
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/addresses")
    public ApiResponse<AddressResponse> create(@Valid @RequestBody AddressRequest request){
        return ApiResponse.<AddressResponse>builder()
                .code(HttpStatus.CREATED.value())
                .message("Create Address")
                .result(addressService.create(request))
                .build();
    }


    @GetMapping("/addresses/{id}")
    public ApiResponse<AddressResponse> fetchById(@Min(value = 1, message = "ID phải lớn hơn 0")
                                                 @PathVariable Long id){
        return ApiResponse.<AddressResponse>builder()
                .code(HttpStatus.OK.value())
                .message("Fetch Address By Id")
                .result(addressService.fetchById(id))
                .build();
    }

    @GetMapping("/addresses")
    public ApiResponse<PageResponse<AddressResponse>> fetchAll(@Min(value = 1, message = "pageNo phải lớn hơn 0")
                                                              @RequestParam(defaultValue = "1") int pageNo,
                                                              @RequestParam(defaultValue = "10") int pageSize,
                                                              @RequestParam(required = false) String sortBy){
        return ApiResponse.<PageResponse<AddressResponse>>builder()
                .code(HttpStatus.OK.value())
                .result(addressService.fetchAll(pageNo, pageSize, sortBy))
                .message("Fetch All Addresses With Pagination")
                .build();
    }

    @PutMapping("/addresses/{id}")
    public ApiResponse<AddressResponse> update(@Min(value = 1, message = "ID phải lớn hơn 0")
                                              @PathVariable Long id, @Valid @RequestBody AddressRequest request){
        return ApiResponse.<AddressResponse>builder()
                .code(HttpStatus.OK.value())
                .message("Update Address By Id")
                .result(addressService.update(id, request))
                .build();
    }


    @DeleteMapping("/addresses/{id}")
    public ApiResponse<Void> delete(@Min(value = 1, message = "ID phải lớn hơn 0")
                                    @PathVariable Long id){
        addressService.delete(id);
        return ApiResponse.<Void>builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("Delete Address By Id")
                .result(null)
                .build();
    }

}
