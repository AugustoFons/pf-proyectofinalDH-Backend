package com.marketplease.marketplease_backend.repositories;

import com.marketplease.marketplease_backend.domain.Product;
import com.marketplease.marketplease_backend.enums.ProductType;
import com.marketplease.marketplease_backend.enums.ReservationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCaseAndIdNot(String name, Long id);

    @Query(value = "SELECT * FROM products ORDER BY RAND() LIMIT :limit", nativeQuery = true)
    List<Product> findRandom(@Param("limit") int limit);

    @Query(value = """
        SELECT DISTINCT p FROM Product p
            LEFT JOIN p.categories c
                WHERE (:q IS NULL
                    OR LOWER(p.name) LIKE LOWER(CONCAT('%', :q, '%'))
                    OR LOWER(COALESCE(p.description, '')) LIKE LOWER(CONCAT('%', :q, '%')))
                    AND (:categoryId IS NULL OR c.id = :categoryId)
                    AND (:productType IS NULL OR p.productType = :productType)
                    AND (
                        :dateFrom IS NULL
                        OR :dateTo IS NULL
                        OR :productType IS NULL
                        OR :productType <> com.marketplease.marketplease_backend.enums.ProductType.RESERVA
                        OR NOT EXISTS (
                            SELECT 1 FROM Reservation r
                            WHERE r.product = p
                              AND r.status IN :blockingStatuses
                              AND r.dateFrom < :dateTo
                              AND r.dateTo > :dateFrom
                        )
                    )
                ORDER BY
                    CASE
                        WHEN :q IS NULL THEN 0
                        WHEN LOWER(p.name) = LOWER(:q) THEN 4
                        WHEN LOWER(p.name) LIKE LOWER(CONCAT(:q, '%')) THEN 3
                        WHEN LOWER(p.name) LIKE LOWER(CONCAT('%', :q, '%')) THEN 2
                        WHEN LOWER(COALESCE(p.description, '')) LIKE LOWER(CONCAT('%', :q, '%')) THEN 1
                        ELSE 0
                    END DESC,
                    p.id DESC
    """, countQuery = """
        SELECT COUNT(DISTINCT p) FROM Product p
            LEFT JOIN p.categories c
                WHERE (:q IS NULL
                    OR LOWER(p.name) LIKE LOWER(CONCAT('%', :q, '%'))
                    OR LOWER(COALESCE(p.description, '')) LIKE LOWER(CONCAT('%', :q, '%')))
                    AND (:categoryId IS NULL OR c.id = :categoryId)
                    AND (:productType IS NULL OR p.productType = :productType)
                    AND (
                        :dateFrom IS NULL
                        OR :dateTo IS NULL
                        OR :productType IS NULL
                        OR :productType <> com.marketplease.marketplease_backend.enums.ProductType.RESERVA
                        OR NOT EXISTS (
                            SELECT 1 FROM Reservation r
                            WHERE r.product = p
                              AND r.status IN :blockingStatuses
                              AND r.dateFrom < :dateTo
                              AND r.dateTo > :dateFrom
                        )
                    )
    """)
    Page<Product> search(@Param("q") String q,
                        @Param("categoryId") Long categoryId,
                        @Param("productType") ProductType productType,
                        @Param("dateFrom") LocalDate dateFrom,
                        @Param("dateTo") LocalDate dateTo,
                        @Param("blockingStatuses") Collection<ReservationStatus> blockingStatuses,
                        Pageable pageable);

    @Query("""
        SELECT DISTINCT p.name FROM Product p
            WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :q, '%'))
            ORDER BY
                CASE
                    WHEN LOWER(p.name) = LOWER(:q) THEN 3
                    WHEN LOWER(p.name) LIKE LOWER(CONCAT(:q, '%')) THEN 2
                    ELSE 1
                END DESC,
                p.name ASC
    """)
    List<String> suggestNames(@Param("q") String q, Pageable pageable);

    boolean existsByNameIgnoreCase(String name);

}
