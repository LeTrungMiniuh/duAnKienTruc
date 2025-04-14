package Spring_AdamStore.service;

import Spring_AdamStore.dto.response.PageResponse;
import Spring_AdamStore.dto.response.ProductImageResponse;
import Spring_AdamStore.entity.ProductImage;
import Spring_AdamStore.exception.FileException;
import jakarta.validation.constraints.Min;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductImageService {

    ProductImageResponse uploadFile(MultipartFile file) throws FileException, IOException;

    void deleteFile(Long id) throws FileException, IOException;

    PageResponse<ProductImageResponse> getAllFiles(int pageNo, int pageSize, String sortBy);
}
