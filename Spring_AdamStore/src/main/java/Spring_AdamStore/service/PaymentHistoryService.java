package Spring_AdamStore.service;

import Spring_AdamStore.constants.PaymentStatus;
import Spring_AdamStore.dto.response.PageResponse;
import Spring_AdamStore.dto.response.PaymentHistoryResponse;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;
import java.util.List;

public interface PaymentHistoryService {

    PageResponse<PaymentHistoryResponse> searchPaymentHistories(int pageNo, int pageSize, String sortBy,
                                                                LocalDateTime startDate, LocalDateTime endDate,
                                                                PaymentStatus paymentStatus);

    void delete(Long id);

}
