package Spring_AdamStore.mapper;

import Spring_AdamStore.dto.basic.EntityBasic;
import Spring_AdamStore.dto.response.DistrictResponse;
import Spring_AdamStore.dto.response.GhnDistrict;
import Spring_AdamStore.entity.District;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-28T14:15:10+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class DistrictMapperImpl implements DistrictMapper {

    @Override
    public DistrictResponse toDistrictResponse(District district) {
        if ( district == null ) {
            return null;
        }

        DistrictResponse.DistrictResponseBuilder districtResponse = DistrictResponse.builder();

        if ( district.getId() != null ) {
            districtResponse.id( district.getId().longValue() );
        }
        if ( district.getName() != null ) {
            districtResponse.name( district.getName() );
        }

        return districtResponse.build();
    }

    @Override
    public District GhnDistrictToDistrict(GhnDistrict ghnDistrict) {
        if ( ghnDistrict == null ) {
            return null;
        }

        District.DistrictBuilder district = District.builder();

        district.id( ghnDistrict.getDistrictId() );
        if ( ghnDistrict.getDistrictName() != null ) {
            district.name( ghnDistrict.getDistrictName() );
        }

        return district.build();
    }

    @Override
    public List<District> GhnDistrictListToDistrictList(List<GhnDistrict> ghnDistrictList) {
        if ( ghnDistrictList == null ) {
            return null;
        }

        List<District> list = new ArrayList<District>( ghnDistrictList.size() );
        for ( GhnDistrict ghnDistrict : ghnDistrictList ) {
            list.add( GhnDistrictToDistrict( ghnDistrict ) );
        }

        return list;
    }

    @Override
    public List<DistrictResponse> toDistrictResponseList(List<District> districtList) {
        if ( districtList == null ) {
            return null;
        }

        List<DistrictResponse> list = new ArrayList<DistrictResponse>( districtList.size() );
        for ( District district : districtList ) {
            list.add( toDistrictResponse( district ) );
        }

        return list;
    }

    @Override
    public EntityBasic toEntityBasic(District district) {
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
}
