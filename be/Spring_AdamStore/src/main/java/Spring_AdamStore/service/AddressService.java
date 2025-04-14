package Spring_AdamStore.service;

import Spring_AdamStore.dto.request.AddressRequest;
import Spring_AdamStore.dto.request.BranchRequest;
import Spring_AdamStore.dto.response.AddressResponse;
import Spring_AdamStore.dto.response.BranchResponse;
import Spring_AdamStore.dto.response.PageResponse;

public interface AddressService {

    AddressResponse create(AddressRequest request);

    AddressResponse fetchById(Long id);

    PageResponse<AddressResponse> fetchAll(int pageNo, int pageSize, String sortBy);

    AddressResponse update(Long id, AddressRequest request);

    void delete(Long id);
}
