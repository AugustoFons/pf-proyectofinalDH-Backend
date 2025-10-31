package com.marketplease.marketplease_backend.repositories;

import com.marketplease.marketplease_backend.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByIdIn(List<Long> ids);

}
