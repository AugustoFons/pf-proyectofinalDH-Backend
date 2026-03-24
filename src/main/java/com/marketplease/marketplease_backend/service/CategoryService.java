package com.marketplease.marketplease_backend.service;

import com.marketplease.marketplease_backend.domain.Category;
import com.marketplease.marketplease_backend.dto.CategoryDtos.*;
import com.marketplease.marketplease_backend.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryRes create(CategoryCreateReq req) {
        if (categoryRepository.existsByNameIgnoreCase(req.name())) {
            throw new IllegalArgumentException("La categoria ya existe: " + req.name());
        }

        Category category = new Category();
        category.setName(req.name());
        var saved = categoryRepository.save(category);
        return new CategoryRes(saved.getId(), saved.getName());
    }

    public CategoryRes update(Long id, CategoryUpdateReq req) {
        var category = categoryRepository.findById(id).orElseThrow(() -> notFound(id));

        if (categoryRepository.existsByNameIgnoreCaseAndIdNot(req.name(), id)) {
            throw new IllegalArgumentException("La categoria ya existe: " + req.name());
        }

        category.setName(req.name());
        var saved = categoryRepository.save(category);
        return new CategoryRes(saved.getId(), saved.getName());
    }

    public void delete(Long id) {
        var category = categoryRepository.findById(id).orElseThrow(() -> notFound(id));

        if (categoryRepository.existsByProducts_Id(id)) {
            throw new IllegalArgumentException("No se puede eliminar la categoria porque tiene productos asociados");
        }

        categoryRepository.delete(category);
    }

    public List<CategoryRes> list() {
        return categoryRepository.findAll().stream()
                .map(c -> new CategoryRes(c.getId(), c.getName()))
                .toList();
    }

    private RuntimeException notFound(Long id) {
        return new EntityNotFoundException("Categoria no encontrada: " + id);
    }

}
