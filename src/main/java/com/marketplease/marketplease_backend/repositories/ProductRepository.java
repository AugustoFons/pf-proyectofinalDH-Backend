package com.marketplease.marketplease_backend.repositories;

import com.marketplease.marketplease_backend.domain.Product;
import com.marketplease.marketplease_backend.enums.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    """)
    Page<Product> search(@Param("q") String q,
                        @Param("categoryId") Long categoryId,
                        @Param("productType") ProductType productType,
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
