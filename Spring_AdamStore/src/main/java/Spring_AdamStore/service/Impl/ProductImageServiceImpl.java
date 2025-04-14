package Spring_AdamStore.service.Impl;

import Spring_AdamStore.dto.response.PageResponse;
import Spring_AdamStore.dto.response.ProductImageResponse;
import Spring_AdamStore.dto.response.PromotionResponse;
import Spring_AdamStore.entity.ProductImage;
import Spring_AdamStore.entity.Promotion;
import Spring_AdamStore.exception.FileException;
import Spring_AdamStore.mapper.ProductImageMapper;
import Spring_AdamStore.repository.ProductImageRepository;
import Spring_AdamStore.service.PageableService;
import Spring_AdamStore.service.ProductImageService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@Slf4j(topic = "PRODUCT-IMAGE-SERVICE")
@RequiredArgsConstructor
public class ProductImageServiceImpl implements ProductImageService {

    private final Cloudinary cloudinary;
    private final ProductImageRepository productImageRepository;
    private final PageableService pageableService;
    private final ProductImageMapper productImageMapper;

    @Value("${cloud.folder-image}")
    private String folderImage;

    @Value("${cloud.max-size-image}")
    private String maxSizeImage;

    private static final List<String> IMAGE_TYPES = Arrays.asList("image/jpeg", "image/png", "image/gif", "image/webp");

    @Override
    public ProductImageResponse uploadFile(MultipartFile file) throws FileException, IOException {
        if (file == null || file.isEmpty()) {
            throw new FileException("File trống. Không thể lưu trữ file");
        }

        validateFile(file, IMAGE_TYPES, maxSizeImage);

        Map<String, Object> options = ObjectUtils.asMap("folder", folderImage);
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), options);

        ProductImage productImage = ProductImage.builder()
                .publicId(uploadResult.get("public_id").toString())
                .fileName(file.getOriginalFilename())
                .imageUrl(uploadResult.get("url").toString())
                .build();

        return productImageMapper.toProductImageResponse(productImageRepository.save(productImage));
    }

    public void deleteFile(Long id) throws FileException, IOException {
        ProductImage productImage = productImageRepository.findById(id)
                .orElseThrow(()-> new FileException("File không tồn tại trong hệ thống"));

        cloudinary.uploader().destroy(productImage.getPublicId(), ObjectUtils.emptyMap());
        productImageRepository.delete(productImage);
    }

    @Override
    public PageResponse<ProductImageResponse> getAllFiles(int pageNo, int pageSize, String sortBy) {
        pageNo = pageNo - 1;

        Pageable pageable = pageableService.createPageable(pageNo, pageSize, sortBy, ProductImage.class);

        Page<ProductImage> productImagePage = productImageRepository.findAll(pageable);

        return PageResponse.<ProductImageResponse>builder()
                .page(productImagePage.getNumber() + 1)
                .size(productImagePage.getSize())
                .totalPages(productImagePage.getTotalPages())
                .totalItems(productImagePage.getTotalElements())
                .items(productImageMapper.toProductImageResponseList(productImagePage.getContent()))
                .build();

    }

    private void validateFile(MultipartFile file, List<String> validTypes, String maxSize) throws FileException {
        if (!validTypes.contains(file.getContentType())) {
            throw new FileException("File " + file.getOriginalFilename() + " không hợp lệ. Định dạng file không được hỗ trợ.");
        }
        if (file.getSize() > parseSize(maxSize)) {
            throw new FileException("Ảnh quá lớn! Chỉ được tối đa " + maxSize + ".");
        }
    }

    private long parseSize(String size) {
        size = size.toUpperCase();
        return Long.parseLong(size.replace("MB", "").trim()) * 1024 * 1024;
    }



}
