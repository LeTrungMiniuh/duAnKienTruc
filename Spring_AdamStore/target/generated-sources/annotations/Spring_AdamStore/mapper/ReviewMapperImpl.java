package Spring_AdamStore.mapper;

import Spring_AdamStore.dto.request.ReviewRequest;
import Spring_AdamStore.dto.request.ReviewUpdateRequest;
import Spring_AdamStore.dto.response.ReviewResponse;
import Spring_AdamStore.entity.Review;
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
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public Review toReview(ReviewRequest request) {
        if ( request == null ) {
            return null;
        }

        Review.ReviewBuilder review = Review.builder();

        if ( request.getComment() != null ) {
            review.comment( request.getComment() );
        }
        if ( request.getRating() != null ) {
            review.rating( request.getRating() );
        }

        return review.build();
    }

    @Override
    public ReviewResponse toReviewResponse(Review review) {
        if ( review == null ) {
            return null;
        }

        ReviewResponse.ReviewResponseBuilder reviewResponse = ReviewResponse.builder();

        if ( review.getComment() != null ) {
            reviewResponse.comment( review.getComment() );
        }
        if ( review.getCreatedAt() != null ) {
            reviewResponse.createdAt( review.getCreatedAt() );
        }
        if ( review.getId() != null ) {
            reviewResponse.id( review.getId() );
        }
        if ( review.getRating() != null ) {
            reviewResponse.rating( review.getRating() );
        }
        if ( review.getUpdatedAt() != null ) {
            reviewResponse.updatedAt( review.getUpdatedAt() );
        }

        return reviewResponse.build();
    }

    @Override
    public void update(Review review, ReviewUpdateRequest request) {
        if ( request == null ) {
            return;
        }

        if ( request.getComment() != null ) {
            review.setComment( request.getComment() );
        }
        if ( request.getRating() != null ) {
            review.setRating( request.getRating() );
        }
    }

    @Override
    public List<ReviewResponse> toReviewResponseList(List<Review> reviewList) {
        if ( reviewList == null ) {
            return null;
        }

        List<ReviewResponse> list = new ArrayList<ReviewResponse>( reviewList.size() );
        for ( Review review : reviewList ) {
            list.add( toReviewResponse( review ) );
        }

        return list;
    }
}
