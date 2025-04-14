package Spring_AdamStore.mapper;

import Spring_AdamStore.dto.basic.WardBasic;
import Spring_AdamStore.dto.response.GhnWard;
import Spring_AdamStore.dto.response.WardResponse;
import Spring_AdamStore.entity.Ward;
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
public class WardMapperImpl implements WardMapper {

    @Override
    public WardResponse toWardResponse(Ward ward) {
        if ( ward == null ) {
            return null;
        }

        WardResponse.WardResponseBuilder wardResponse = WardResponse.builder();

        if ( ward.getCode() != null ) {
            wardResponse.code( ward.getCode() );
        }
        if ( ward.getName() != null ) {
            wardResponse.name( ward.getName() );
        }

        return wardResponse.build();
    }

    @Override
    public Ward ghnWardToWard(GhnWard ghnWard) {
        if ( ghnWard == null ) {
            return null;
        }

        Ward.WardBuilder ward = Ward.builder();

        if ( ghnWard.getWardCode() != null ) {
            ward.code( ghnWard.getWardCode() );
        }
        if ( ghnWard.getWardName() != null ) {
            ward.name( ghnWard.getWardName() );
        }

        return ward.build();
    }

    @Override
    public List<Ward> ghnWardListToWardList(List<GhnWard> ghnWardList) {
        if ( ghnWardList == null ) {
            return null;
        }

        List<Ward> list = new ArrayList<Ward>( ghnWardList.size() );
        for ( GhnWard ghnWard : ghnWardList ) {
            list.add( ghnWardToWard( ghnWard ) );
        }

        return list;
    }

    @Override
    public List<WardResponse> toWardResponseList(List<Ward> wardList) {
        if ( wardList == null ) {
            return null;
        }

        List<WardResponse> list = new ArrayList<WardResponse>( wardList.size() );
        for ( Ward ward : wardList ) {
            list.add( toWardResponse( ward ) );
        }

        return list;
    }

    @Override
    public WardBasic toWardBasic(Ward ward) {
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
