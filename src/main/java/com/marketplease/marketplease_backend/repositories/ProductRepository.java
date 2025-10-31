package com.marketplease.marketplease_backend.repositories;

import com.marketplease.marketplease_backend.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
