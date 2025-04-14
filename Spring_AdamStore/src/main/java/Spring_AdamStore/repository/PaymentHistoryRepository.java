package Spring_AdamStore.repository;

import Spring_AdamStore.constants.PaymentStatus;
import Spring_AdamStore.entity.Order;
import Spring_AdamStore.entity.PaymentHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long> {

    Optional<PaymentHistory> findByOrderIdAndPaymentStatus(Long orderId, PaymentStatus paymentStatus);


    @Query("SELECT p FROM PaymentHistory p " +
            "WHERE (:paymentStatus IS NULL OR p.paymentStatus = :paymentStatus) " +
            "AND (:startDate IS NULL OR p.paymentTime >= :startDate) " +
            "AND (:endDate IS NULL OR p.paymentTime <= :endDate)")
    Page<PaymentHistory> searchPaymentHistories(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
            @Param("paymentStatus") PaymentStatus paymentStatus, Pageable pageable);

}
