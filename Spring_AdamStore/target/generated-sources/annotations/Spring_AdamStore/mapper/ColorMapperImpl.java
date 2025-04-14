package Spring_AdamStore.mapper;

import Spring_AdamStore.dto.basic.EntityBasic;
import Spring_AdamStore.dto.request.ColorRequest;
import Spring_AdamStore.dto.response.ColorResponse;
import Spring_AdamStore.entity.Color;
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
public class ColorMapperImpl implements ColorMapper {

    @Override
    public Color toColor(ColorRequest request) {
        if ( request == null ) {
            return null;
        }

        Color.ColorBuilder color = Color.builder();

        if ( request.getName() != null ) {
            color.name( request.getName() );
        }

        return color.build();
    }

    @Override
    public ColorResponse toColorResponse(Color color) {
        if ( color == null ) {
            return null;
        }

        ColorResponse.ColorResponseBuilder colorResponse = ColorResponse.builder();

        if ( color.getId() != null ) {
            colorResponse.id( color.getId() );
        }
        if ( color.getName() != null ) {
            colorResponse.name( color.getName() );
        }

        return colorResponse.build();
    }

    @Override
    public void update(Color color, ColorRequest request) {
        if ( request == null ) {
            return;
        }

        if ( request.getName() != null ) {
            color.setName( request.getName() );
        }
    }

    @Override
    public List<ColorResponse> toColorResponseList(List<Color> colorList) {
        if ( colorList == null ) {
            return null;
        }

        List<ColorResponse> list = new ArrayList<ColorResponse>( colorList.size() );
        for ( Color color : colorList ) {
            list.add( toColorResponse( color ) );
        }

        return list;
    }

    @Override
    public EntityBasic toEntityBasic(Color color) {
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
}
