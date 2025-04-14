package Spring_AdamStore.mapper;

import Spring_AdamStore.dto.request.BranchRequest;
import Spring_AdamStore.dto.response.BranchResponse;
import Spring_AdamStore.dto.response.ProductImageResponse;
import Spring_AdamStore.entity.Branch;
import Spring_AdamStore.entity.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductImageMapper {

    ProductImageResponse toProductImageResponse(ProductImage image);

    List<ProductImageResponse> toProductImageResponseList(List<ProductImage> imageList);

}
