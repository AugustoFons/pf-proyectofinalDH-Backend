package com.marketplease.marketplease_backend.repositories;

import com.marketplease.marketplease_backend.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findByUserIdOrderByCreatedAtDesc(Long userId);

    List<Purchase> findByUserEmailOrderByCreatedAtDesc(String email);

    List<Purchase> findByProductIdAndUserId(Long productId, Long userId);
}
