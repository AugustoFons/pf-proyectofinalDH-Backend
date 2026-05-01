package com.marketplease.marketplease_backend.repositories;

import com.marketplease.marketplease_backend.domain.Reservation;
import com.marketplease.marketplease_backend.enums.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("""
        SELECT COUNT(r) > 0 FROM Reservation r
        WHERE r.product.id = :productId
          AND r.status IN :blockingStatuses
          AND r.dateFrom < :dateTo
          AND r.dateTo > :dateFrom
    """)
    boolean existsOverlap(@Param("productId") Long productId,
                          @Param("dateFrom") LocalDate dateFrom,
                          @Param("dateTo") LocalDate dateTo,
                          @Param("blockingStatuses") Collection<ReservationStatus> blockingStatuses);

    @Query("""
        SELECT r FROM Reservation r
        WHERE r.product.id = :productId
          AND r.status IN :blockingStatuses
          AND r.dateFrom < :dateTo
          AND r.dateTo > :dateFrom
        ORDER BY r.dateFrom ASC, r.dateTo ASC
    """)
    List<Reservation> findOverlappingInWindow(@Param("productId") Long productId,
                                              @Param("dateFrom") LocalDate dateFrom,
                                              @Param("dateTo") LocalDate dateTo,
                                              @Param("blockingStatuses") Collection<ReservationStatus> blockingStatuses);
}
