package Spring_AdamStore.mapper;

import Spring_AdamStore.dto.basic.EntityBasic;
import Spring_AdamStore.dto.basic.ProductVariantBasic;
import Spring_AdamStore.dto.basic.UserBasic;
import Spring_AdamStore.dto.basic.WardBasic;
import Spring_AdamStore.dto.response.AddressResponse;
import Spring_AdamStore.dto.response.OrderItemResponse;
import Spring_AdamStore.dto.response.OrderResponse;
import Spring_AdamStore.entity.Address;
import Spring_AdamStore.entity.Color;
import Spring_AdamStore.entity.District;
import Spring_AdamStore.entity.Order;
import Spring_AdamStore.entity.OrderItem;
import Spring_AdamStore.entity.Product;
import Spring_AdamStore.entity.ProductVariant;
import Spring_AdamStore.entity.Province;
import Spring_AdamStore.entity.Size;
import Spring_AdamStore.entity.User;
import Spring_AdamStore.entity.Ward;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-28T14:15:09+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderResponse toOrderResponse(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderResponse.OrderResponseBuilder orderResponse = OrderResponse.builder();

        if ( order.getAddress() != null ) {
            orderResponse.address( addressToAddressResponse( order.getAddress() ) );
        }
        List<OrderItemResponse> list = orderItemSetToOrderItemResponseList( order.getOrderItems() );
        if ( list != null ) {
            orderResponse.orderItems( list );
        }
        if ( order.getCreatedAt() != null ) {
            orderResponse.createdAt( order.getCreatedAt() );
        }
        if ( order.getId() != null ) {
            orderResponse.id( order.getId() );
        }
        if ( order.getOrderDate() != null ) {
            orderResponse.orderDate( order.getOrderDate() );
        }
        if ( order.getOrderStatus() != null ) {
            orderResponse.orderStatus( order.getOrderStatus() );
        }
        if ( order.getTotalPrice() != null ) {
            orderResponse.totalPrice( order.getTotalPrice() );
        }
        if ( order.getUpdatedAt() != null ) {
            orderResponse.updatedAt( order.getUpdatedAt() );
        }
        if ( order.getUser() != null ) {
            orderResponse.user( userToUserBasic( order.getUser() ) );
        }

        return orderResponse.build();
    }

    @Override
    public List<OrderResponse> toOrderResponseList(List<Order> orderList) {
        if ( orderList == null ) {
            return null;
        }

        List<OrderResponse> list = new ArrayList<OrderResponse>( orderList.size() );
        for ( Order order : orderList ) {
            list.add( toOrderResponse( order ) );
        }

        return list;
    }

    protected EntityBasic districtToEntityBasic(District district) {
        if ( district == null ) {
            return null;
        }

        EntityBasic.EntityBasicBuilder entityBasic = EntityBasic.builder();

        if ( district.getId() != null ) {
            entityBasic.id( district.getId().longValue() );
        }
        if ( district.getName() != null ) {
            entityBasic.name( district.getName() );
        }

        return entityBasic.build();
    }

    protected EntityBasic provinceToEntityBasic(Province province) {
        if ( province == null ) {
            return null;
        }

        EntityBasic.EntityBasicBuilder entityBasic = EntityBasic.builder();

        if ( province.getId() != null ) {
            entityBasic.id( province.getId().longValue() );
        }
        if ( province.getName() != null ) {
            entityBasic.name( province.getName() );
        }

        return entityBasic.build();
    }

    protected UserBasic userToUserBasic(User user) {
        if ( user == null ) {
            return null;
        }

        UserBasic.UserBasicBuilder userBasic = UserBasic.builder();

        if ( user.getEmail() != null ) {
            userBasic.email( user.getEmail() );
        }
        if ( user.getId() != null ) {
            userBasic.id( user.getId() );
        }
        if ( user.getName() != null ) {
            userBasic.name( user.getName() );
        }
        if ( user.getPhone() != null ) {
            userBasic.phone( user.getPhone() );
        }

        return userBasic.build();
    }

    protected WardBasic wardToWardBasic(Ward ward) {
        if ( ward == null ) {
            return null;
        }

        WardBasic.WardBasicBuilder wardBasic = WardBasic.builder();

        if ( ward.getCode() != null ) {
            wardBasic.code( Long.parseLong( ward.getCode() ) );
        }
        if ( ward.getName() != null ) {
            wardBasic.name( ward.getName() );
        }

        return wardBasic.build();
    }

    protected AddressResponse addressToAddressResponse(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressResponse.AddressResponseBuilder addressResponse = AddressResponse.builder();

        if ( address.getDistrict() != null ) {
            addressResponse.district( districtToEntityBasic( address.getDistrict() ) );
        }
        if ( address.getId() != null ) {
            addressResponse.id( address.getId() );
        }
        if ( address.getIsDefault() != null ) {
            addressResponse.isDefault( address.getIsDefault() );
        }
        if ( address.getProvince() != null ) {
            addressResponse.province( provinceToEntityBasic( address.getProvince() ) );
        }
        if ( address.getStreetDetail() != null ) {
            addressResponse.streetDetail( address.getStreetDetail() );
        }
        if ( address.getUser() != null ) {
            addressResponse.user( userToUserBasic( address.getUser() ) );
        }
        if ( address.getWard() != null ) {
            addressResponse.ward( wardToWardBasic( address.getWard() ) );
        }

        return addressResponse.build();
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

    protected OrderItemResponse orderItemToOrderItemResponse(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemResponse.OrderItemResponseBuilder orderItemResponse = OrderItemResponse.builder();

        if ( orderItem.getId() != null ) {
            orderItemResponse.id( orderItem.getId() );
        }
        if ( orderItem.getProductVariant() != null ) {
            orderItemResponse.productVariant( productVariantToProductVariantBasic( orderItem.getProductVariant() ) );
        }
        if ( orderItem.getQuantity() != null ) {
            orderItemResponse.quantity( orderItem.getQuantity() );
        }
        if ( orderItem.getUnitPrice() != null ) {
            orderItemResponse.unitPrice( orderItem.getUnitPrice() );
        }

        return orderItemResponse.build();
    }

    protected List<OrderItemResponse> orderItemSetToOrderItemResponseList(Set<OrderItem> set) {
        if ( set == null ) {
            return null;
        }

        List<OrderItemResponse> list = new ArrayList<OrderItemResponse>( set.size() );
        for ( OrderItem orderItem : set ) {
            list.add( orderItemToOrderItemResponse( orderItem ) );
        }

        return list;
    }
}
