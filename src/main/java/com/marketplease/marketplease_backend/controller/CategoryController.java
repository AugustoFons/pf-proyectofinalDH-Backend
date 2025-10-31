package com.marketplease.marketplease_backend.controller;
import com.marketplease.marketplease_backend.dto.CategoryDtos.*;
import com.marketplease.marketplease_backend.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //Post
    @PostMapping
    public CategoryRes create(@Valid @RequestBody CategoryCreateReq req) {
        return categoryService.create(req);
    }

    //GEt
    @GetMapping
    public List<CategoryRes> list() {
        return categoryService.list();
    }
}
