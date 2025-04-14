package Spring_AdamStore.mapper;

import Spring_AdamStore.dto.basic.EntityBasic;
import Spring_AdamStore.dto.response.GhnProvince;
import Spring_AdamStore.dto.response.ProvinceResponse;
import Spring_AdamStore.entity.Province;
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
public class ProvinceMapperImpl implements ProvinceMapper {

    @Override
    public ProvinceResponse toProvinceResponse(Province province) {
        if ( province == null ) {
            return null;
        }

        ProvinceResponse.ProvinceResponseBuilder provinceResponse = ProvinceResponse.builder();

        if ( province.getId() != null ) {
            provinceResponse.id( province.getId().longValue() );
        }
        if ( province.getName() != null ) {
            provinceResponse.name( province.getName() );
        }

        return provinceResponse.build();
    }

    @Override
    public Province GhnProvinceToProvince(GhnProvince ghnProvince) {
        if ( ghnProvince == null ) {
            return null;
        }

        Province.ProvinceBuilder province = Province.builder();

        province.id( ghnProvince.getProvinceId() );
        if ( ghnProvince.getProvinceName() != null ) {
            province.name( ghnProvince.getProvinceName() );
        }

        return province.build();
    }

    @Override
    public List<Province> GhnProvinceListToProvinceList(List<GhnProvince> ghnProvinceList) {
        if ( ghnProvinceList == null ) {
            return null;
        }

        List<Province> list = new ArrayList<Province>( ghnProvinceList.size() );
        for ( GhnProvince ghnProvince : ghnProvinceList ) {
            list.add( GhnProvinceToProvince( ghnProvince ) );
        }

        return list;
    }

    @Override
    public List<ProvinceResponse> toProvinceResponseList(List<Province> provinceList) {
        if ( provinceList == null ) {
            return null;
        }

        List<ProvinceResponse> list = new ArrayList<ProvinceResponse>( provinceList.size() );
        for ( Province province : provinceList ) {
            list.add( toProvinceResponse( province ) );
        }

        return list;
    }

    @Override
    public EntityBasic toEntityBasic(Province province) {
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
}
