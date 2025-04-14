package Spring_AdamStore.mapper;

import Spring_AdamStore.dto.basic.EntityBasic;
import Spring_AdamStore.dto.basic.UserBasic;
import Spring_AdamStore.dto.basic.WardBasic;
import Spring_AdamStore.dto.request.AddressRequest;
import Spring_AdamStore.dto.response.AddressResponse;
import Spring_AdamStore.entity.Address;
import Spring_AdamStore.entity.District;
import Spring_AdamStore.entity.Province;
import Spring_AdamStore.entity.User;
import Spring_AdamStore.entity.Ward;
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
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address toAddress(AddressRequest request) {
        if ( request == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        if ( request.getIsDefault() != null ) {
            address.isDefault( request.getIsDefault() );
        }
        if ( request.getStreetDetail() != null ) {
            address.streetDetail( request.getStreetDetail() );
        }

        return address.build();
    }

    @Override
    public AddressResponse toAddressResponse(Address address) {
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

    @Override
    public void update(Address address, AddressRequest request) {
        if ( request == null ) {
            return;
        }

        if ( request.getIsDefault() != null ) {
            address.setIsDefault( request.getIsDefault() );
        }
        if ( request.getStreetDetail() != null ) {
            address.setStreetDetail( request.getStreetDetail() );
        }
    }

    @Override
    public List<AddressResponse> toAddressResponseList(List<Address> addressList) {
        if ( addressList == null ) {
            return null;
        }

        List<AddressResponse> list = new ArrayList<AddressResponse>( addressList.size() );
        for ( Address address : addressList ) {
            list.add( toAddressResponse( address ) );
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
}
