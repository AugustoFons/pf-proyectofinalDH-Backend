package com.marketplease.marketplease_backend.repositories;

import com.marketplease.marketplease_backend.domain.Product;
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

    @Query("""
        SELECT DISTINCT p FROM Product p
            LEFT JOIN p.categories c
                WHERE (:q IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :q, '%')))
                    AND (:categoryId IS NULL OR c.id = :categoryId)
    """)
    Page<Product> search(@Param("q") String q, @Param("categoryId") Long categoryId, Pageable pageable);
}
