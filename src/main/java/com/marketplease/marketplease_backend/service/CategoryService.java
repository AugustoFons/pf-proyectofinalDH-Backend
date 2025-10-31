package com.marketplease.marketplease_backend.service;

import com.marketplease.marketplease_backend.domain.Category;
import com.marketplease.marketplease_backend.dto.CategoryDtos.*;
import com.marketplease.marketplease_backend.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
private final CategoryRepository categoryRepository;

public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
}

    public CategoryRes create(CategoryCreateReq req) {
        Category category = new Category();
        category.setName(req.name());
        var saved = categoryRepository.save(category);
        return new CategoryRes(saved.getId(), saved.getName());
    }

    public List<CategoryRes> list() {
        return categoryRepository.findAll().stream()
                .map(c -> new CategoryRes(c.getId(), c.getName()))
                .toList();
    }

}
