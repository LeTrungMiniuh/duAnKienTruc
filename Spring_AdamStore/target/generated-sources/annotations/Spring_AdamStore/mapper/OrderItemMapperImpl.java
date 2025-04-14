package Spring_AdamStore.mapper;

import Spring_AdamStore.dto.basic.EntityBasic;
import Spring_AdamStore.dto.basic.ProductVariantBasic;
import Spring_AdamStore.dto.response.OrderItemResponse;
import Spring_AdamStore.entity.Color;
import Spring_AdamStore.entity.OrderItem;
import Spring_AdamStore.entity.Product;
import Spring_AdamStore.entity.ProductVariant;
import Spring_AdamStore.entity.Size;
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
public class OrderItemMapperImpl implements OrderItemMapper {

    @Override
    public OrderItemResponse toOrderItemResponse(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemResponse.OrderItemResponseBuilder orderItemResponse = OrderItemResponse.builder();

        if ( orderItem.getProductVariant() != null ) {
            orderItemResponse.productVariant( productVariantToProductVariantBasic( orderItem.getProductVariant() ) );
        }
        if ( orderItem.getId() != null ) {
            orderItemResponse.id( orderItem.getId() );
        }
        if ( orderItem.getQuantity() != null ) {
            orderItemResponse.quantity( orderItem.getQuantity() );
        }
        if ( orderItem.getUnitPrice() != null ) {
            orderItemResponse.unitPrice( orderItem.getUnitPrice() );
        }

        return orderItemResponse.build();
    }

    @Override
    public List<OrderItemResponse> toOrderItemResponseList(List<OrderItem> orderItemList) {
        if ( orderItemList == null ) {
            return null;
        }

        List<OrderItemResponse> list = new ArrayList<OrderItemResponse>( orderItemList.size() );
        for ( OrderItem orderItem : orderItemList ) {
            list.add( toOrderItemResponse( orderItem ) );
        }

        return list;
    }

    protected EntityBasic colorToEntityBasic(Color color) {
        if ( color == null ) {
            return null;
        }

        EntityBasic.EntityBasicBuilder entityBasic = EntityBasic.builder();

        if ( color.getId() != null ) {
            entityBasic.id( color.getId() );
        }
        if ( color.getName() != null ) {
            entityBasic.name( color.getName() );
        }

        return entityBasic.build();
    }

    protected EntityBasic productToEntityBasic(Product product) {
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

    protected EntityBasic sizeToEntityBasic(Size size) {
        if ( size == null ) {
            return null;
        }

        EntityBasic.EntityBasicBuilder entityBasic = EntityBasic.builder();

        if ( size.getId() != null ) {
            entityBasic.id( size.getId() );
        }
        if ( size.getName() != null ) {
            entityBasic.name( size.getName() );
        }

        return entityBasic.build();
    }

    protected ProductVariantBasic productVariantToProductVariantBasic(ProductVariant productVariant) {
        if ( productVariant == null ) {
            return null;
        }

        ProductVariantBasic.ProductVariantBasicBuilder productVariantBasic = ProductVariantBasic.builder();

        if ( productVariant.getColor() != null ) {
            productVariantBasic.color( colorToEntityBasic( productVariant.getColor() ) );
        }
        if ( productVariant.getId() != null ) {
            productVariantBasic.id( productVariant.getId() );
        }
        if ( productVariant.getProduct() != null ) {
            productVariantBasic.product( productToEntityBasic( productVariant.getProduct() ) );
        }
        if ( productVariant.getSize() != null ) {
            productVariantBasic.size( sizeToEntityBasic( productVariant.getSize() ) );
        }

        return productVariantBasic.build();
    }
}
