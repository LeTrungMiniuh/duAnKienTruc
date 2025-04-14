package Spring_AdamStore.mapper;

import Spring_AdamStore.dto.basic.EntityBasic;
import Spring_AdamStore.dto.request.SizeRequest;
import Spring_AdamStore.dto.response.SizeResponse;
import Spring_AdamStore.entity.Size;
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
public class SizeMapperImpl implements SizeMapper {

    @Override
    public SizeResponse toSizeResponse(Size size) {
        if ( size == null ) {
            return null;
        }

        SizeResponse.SizeResponseBuilder sizeResponse = SizeResponse.builder();

        if ( size.getId() != null ) {
            sizeResponse.id( size.getId() );
        }
        if ( size.getName() != null ) {
            sizeResponse.name( size.getName() );
        }

        return sizeResponse.build();
    }

    @Override
    public void update(Size size, SizeRequest request) {
        if ( request == null ) {
            return;
        }

        if ( request.getName() != null ) {
            size.setName( request.getName() );
        }
    }

    @Override
    public List<SizeResponse> toSizeResponseList(List<Size> sizeList) {
        if ( sizeList == null ) {
            return null;
        }

        List<SizeResponse> list = new ArrayList<SizeResponse>( sizeList.size() );
        for ( Size size : sizeList ) {
            list.add( toSizeResponse( size ) );
        }

        return list;
    }

    @Override
    public EntityBasic toEntityBasic(Size size) {
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
}
