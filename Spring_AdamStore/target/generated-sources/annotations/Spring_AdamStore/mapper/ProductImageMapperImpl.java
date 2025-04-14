package Spring_AdamStore.mapper;

import Spring_AdamStore.dto.response.ProductImageResponse;
import Spring_AdamStore.entity.ProductImage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-28T14:15:09+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class ProductImageMapperImpl implements ProductImageMapper {

    @Override
    public ProductImageResponse toProductImageResponse(ProductImage image) {
        if ( image == null ) {
            return null;
        }

        ProductImageResponse.ProductImageResponseBuilder productImageResponse = ProductImageResponse.builder();

        if ( image.getFileName() != null ) {
            productImageResponse.fileName( image.getFileName() );
        }
        if ( image.getId() != null ) {
            productImageResponse.id( image.getId() );
        }
        if ( image.getImageUrl() != null ) {
            productImageResponse.imageUrl( image.getImageUrl() );
        }

        return productImageResponse.build();
    }

    @Override
    public List<ProductImageResponse> toProductImageResponseList(List<ProductImage> imageList) {
        if ( imageList == null ) {
            return null;
        }

        List<ProductImageResponse> list = new ArrayList<ProductImageResponse>( imageList.size() );
        for ( ProductImage productImage : imageList ) {
            list.add( toProductImageResponse( productImage ) );
        }

        return list;
    }
}
