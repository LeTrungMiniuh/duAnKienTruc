package Spring_AdamStore.mapper;

import Spring_AdamStore.dto.basic.EntityBasic;
import Spring_AdamStore.dto.request.ProductRequest;
import Spring_AdamStore.dto.request.ProductUpdateRequest;
import Spring_AdamStore.dto.response.ProductImageResponse;
import Spring_AdamStore.dto.response.ProductResponse;
import Spring_AdamStore.entity.Category;
import Spring_AdamStore.entity.Product;
import Spring_AdamStore.entity.ProductImage;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-28T14:15:10+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private ProductVariantMapper productVariantMapper;

    @Override
    public Product toProduct(ProductRequest request) {
        if ( request == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        if ( request.getDescription() != null ) {
            product.description( request.getDescription() );
        }
        if ( request.getName() != null ) {
            product.name( request.getName() );
        }

        return product.build();
    }

    @Override
    public ProductResponse toProductResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponse.ProductResponseBuilder productResponse = ProductResponse.builder();

        Set<EntityBasic> set = productVariantMapper.toSizeSet( product.getProductVariants() );
        if ( set != null ) {
            productResponse.sizes( set );
        }
        Set<EntityBasic> set1 = productVariantMapper.toColorSet( product.getProductVariants() );
        if ( set1 != null ) {
            productResponse.colors( set1 );
        }
        if ( product.getProductVariants() != null ) {
            productResponse.price( productVariantMapper.getPriceFromFirstVariant( product.getProductVariants() ) );
        }
        if ( product.getProductVariants() != null ) {
            productResponse.quantity( productVariantMapper.getQuantityFromFirstVariant( product.getProductVariants() ) );
        }
        if ( product.getAverageRating() != null ) {
            productResponse.averageRating( product.getAverageRating() );
        }
        if ( product.getCategory() != null ) {
            productResponse.category( categoryToEntityBasic( product.getCategory() ) );
        }
        if ( product.getCreatedAt() != null ) {
            productResponse.createdAt( product.getCreatedAt() );
        }
        if ( product.getCreatedBy() != null ) {
            productResponse.createdBy( product.getCreatedBy() );
        }
        if ( product.getDescription() != null ) {
            productResponse.description( product.getDescription() );
        }
        if ( product.getId() != null ) {
            productResponse.id( product.getId() );
        }
        if ( product.getIsAvailable() != null ) {
            productResponse.isAvailable( product.getIsAvailable() );
        }
        if ( product.getName() != null ) {
            productResponse.name( product.getName() );
        }
        Set<ProductImageResponse> set2 = productImageSetToProductImageResponseSet( product.getProductImages() );
        if ( set2 != null ) {
            productResponse.productImages( set2 );
        }
        if ( product.getSoldQuantity() != null ) {
            productResponse.soldQuantity( product.getSoldQuantity() );
        }
        if ( product.getStatus() != null ) {
            productResponse.status( product.getStatus() );
        }
        if ( product.getTotalReviews() != null ) {
            productResponse.totalReviews( product.getTotalReviews() );
        }
        if ( product.getUpdatedAt() != null ) {
            productResponse.updatedAt( product.getUpdatedAt() );
        }
        if ( product.getUpdatedBy() != null ) {
            productResponse.updatedBy( product.getUpdatedBy() );
        }

        return productResponse.build();
    }

    @Override
    public void updateProduct(Product product, ProductUpdateRequest request) {
        if ( request == null ) {
            return;
        }

        if ( request.getDescription() != null ) {
            product.setDescription( request.getDescription() );
        }
        if ( request.getName() != null ) {
            product.setName( request.getName() );
        }
    }

    @Override
    public List<ProductResponse> toProductResponseList(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductResponse> list = new ArrayList<ProductResponse>( products.size() );
        for ( Product product : products ) {
            list.add( toProductResponse( product ) );
        }

        return list;
    }

    @Override
    public EntityBasic toEntityBasic(Product product) {
        if ( product == null ) {
            return null;
        }

        EntityBasic.EntityBasicBuilder entityBasic = EntityBasic.builder();

        if ( product.getId() != null ) {
            entityBasic.id( product.getId() );
        }
        if ( product.getName() != null ) {
            entityBasic.name( product.getName() );
        }

        return entityBasic.build();
    }

    protected EntityBasic categoryToEntityBasic(Category category) {
        if ( category == null ) {
            return null;
        }

        EntityBasic.EntityBasicBuilder entityBasic = EntityBasic.builder();

        if ( category.getId() != null ) {
            entityBasic.id( category.getId() );
        }
        if ( category.getName() != null ) {
            entityBasic.name( category.getName() );
        }

        return entityBasic.build();
    }

    protected ProductImageResponse productImageToProductImageResponse(ProductImage productImage) {
        if ( productImage == null ) {
            return null;
        }

        ProductImageResponse.ProductImageResponseBuilder productImageResponse = ProductImageResponse.builder();

        if ( productImage.getFileName() != null ) {
            productImageResponse.fileName( productImage.getFileName() );
        }
        if ( productImage.getId() != null ) {
            productImageResponse.id( productImage.getId() );
        }
        if ( productImage.getImageUrl() != null ) {
            productImageResponse.imageUrl( productImage.getImageUrl() );
        }

        return productImageResponse.build();
    }

    protected Set<ProductImageResponse> productImageSetToProductImageResponseSet(Set<ProductImage> set) {
        if ( set == null ) {
            return null;
        }

        Set<ProductImageResponse> set1 = new LinkedHashSet<ProductImageResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ProductImage productImage : set ) {
            set1.add( productImageToProductImageResponse( productImage ) );
        }

        return set1;
    }
}
