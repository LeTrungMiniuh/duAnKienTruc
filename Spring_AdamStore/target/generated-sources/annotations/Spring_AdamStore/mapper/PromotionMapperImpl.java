package Spring_AdamStore.mapper;

import Spring_AdamStore.dto.request.PromotionRequest;
import Spring_AdamStore.dto.request.PromotionUpdateRequest;
import Spring_AdamStore.dto.response.PromotionResponse;
import Spring_AdamStore.entity.Promotion;
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
public class PromotionMapperImpl implements PromotionMapper {

    @Override
    public Promotion toPromotion(PromotionRequest request) {
        if ( request == null ) {
            return null;
        }

        Promotion.PromotionBuilder promotion = Promotion.builder();

        if ( request.getCode() != null ) {
            promotion.code( request.getCode() );
        }
        if ( request.getDescription() != null ) {
            promotion.description( request.getDescription() );
        }
        if ( request.getDiscountPercent() != null ) {
            promotion.discountPercent( request.getDiscountPercent() );
        }
        if ( request.getEndDate() != null ) {
            promotion.endDate( request.getEndDate() );
        }
        if ( request.getStartDate() != null ) {
            promotion.startDate( request.getStartDate() );
        }

        return promotion.build();
    }

    @Override
    public PromotionResponse toPromotionResponse(Promotion promotion) {
        if ( promotion == null ) {
            return null;
        }

        PromotionResponse.PromotionResponseBuilder promotionResponse = PromotionResponse.builder();

        if ( promotion.getCode() != null ) {
            promotionResponse.code( promotion.getCode() );
        }
        if ( promotion.getCreatedAt() != null ) {
            promotionResponse.createdAt( promotion.getCreatedAt() );
        }
        if ( promotion.getCreatedBy() != null ) {
            promotionResponse.createdBy( promotion.getCreatedBy() );
        }
        if ( promotion.getDescription() != null ) {
            promotionResponse.description( promotion.getDescription() );
        }
        if ( promotion.getDiscountPercent() != null ) {
            promotionResponse.discountPercent( promotion.getDiscountPercent() );
        }
        if ( promotion.getEndDate() != null ) {
            promotionResponse.endDate( promotion.getEndDate() );
        }
        if ( promotion.getId() != null ) {
            promotionResponse.id( promotion.getId() );
        }
        if ( promotion.getStartDate() != null ) {
            promotionResponse.startDate( promotion.getStartDate() );
        }
        if ( promotion.getStatus() != null ) {
            promotionResponse.status( promotion.getStatus() );
        }
        if ( promotion.getUpdatedAt() != null ) {
            promotionResponse.updatedAt( promotion.getUpdatedAt() );
        }
        if ( promotion.getUpdatedBy() != null ) {
            promotionResponse.updatedBy( promotion.getUpdatedBy() );
        }

        return promotionResponse.build();
    }

    @Override
    public void update(Promotion promotion, PromotionUpdateRequest request) {
        if ( request == null ) {
            return;
        }

        if ( request.getCode() != null ) {
            promotion.setCode( request.getCode() );
        }
        if ( request.getDescription() != null ) {
            promotion.setDescription( request.getDescription() );
        }
        if ( request.getDiscountPercent() != null ) {
            promotion.setDiscountPercent( request.getDiscountPercent() );
        }
        if ( request.getEndDate() != null ) {
            promotion.setEndDate( request.getEndDate() );
        }
        if ( request.getStartDate() != null ) {
            promotion.setStartDate( request.getStartDate() );
        }
    }

    @Override
    public List<PromotionResponse> toPromotionResponseList(List<Promotion> promotionList) {
        if ( promotionList == null ) {
            return null;
        }

        List<PromotionResponse> list = new ArrayList<PromotionResponse>( promotionList.size() );
        for ( Promotion promotion : promotionList ) {
            list.add( toPromotionResponse( promotion ) );
        }

        return list;
    }
}
