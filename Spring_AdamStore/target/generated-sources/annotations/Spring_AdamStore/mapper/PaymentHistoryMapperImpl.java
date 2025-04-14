package Spring_AdamStore.mapper;

import Spring_AdamStore.dto.response.PaymentHistoryResponse;
import Spring_AdamStore.entity.PaymentHistory;
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
public class PaymentHistoryMapperImpl implements PaymentHistoryMapper {

    @Override
    public PaymentHistoryResponse toPaymentHistoryResponse(PaymentHistory paymentHistory) {
        if ( paymentHistory == null ) {
            return null;
        }

        PaymentHistoryResponse.PaymentHistoryResponseBuilder paymentHistoryResponse = PaymentHistoryResponse.builder();

        if ( paymentHistory.getId() != null ) {
            paymentHistoryResponse.id( paymentHistory.getId() );
        }
        if ( paymentHistory.getIsPrimary() != null ) {
            paymentHistoryResponse.isPrimary( paymentHistory.getIsPrimary() );
        }
        if ( paymentHistory.getPaymentMethod() != null ) {
            paymentHistoryResponse.paymentMethod( paymentHistory.getPaymentMethod().name() );
        }
        if ( paymentHistory.getPaymentStatus() != null ) {
            paymentHistoryResponse.paymentStatus( paymentHistory.getPaymentStatus() );
        }
        if ( paymentHistory.getPaymentTime() != null ) {
            paymentHistoryResponse.paymentTime( paymentHistory.getPaymentTime() );
        }
        if ( paymentHistory.getTotalAmount() != null ) {
            paymentHistoryResponse.totalAmount( paymentHistory.getTotalAmount() );
        }

        return paymentHistoryResponse.build();
    }

    @Override
    public List<PaymentHistoryResponse> toPaymentHistoryResponseList(List<PaymentHistory> paymentHistoryList) {
        if ( paymentHistoryList == null ) {
            return null;
        }

        List<PaymentHistoryResponse> list = new ArrayList<PaymentHistoryResponse>( paymentHistoryList.size() );
        for ( PaymentHistory paymentHistory : paymentHistoryList ) {
            list.add( toPaymentHistoryResponse( paymentHistory ) );
        }

        return list;
    }
}
