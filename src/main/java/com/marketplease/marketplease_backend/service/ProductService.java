package com.marketplease.marketplease_backend.service;

import com.marketplease.marketplease_backend.domain.Category;
import com.marketplease.marketplease_backend.domain.Product;
import com.marketplease.marketplease_backend.domain.ProductImage;
import com.marketplease.marketplease_backend.dto.ProductDtos.*;
import com.marketplease.marketplease_backend.repositories.CategoryRepository;
import com.marketplease.marketplease_backend.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Page<ProductRes> list(int page, int size) {
        var pageable = PageRequest.of(page, Math.min(size, 10), Sort.by(Sort.Direction.DESC, "id"));
        return productRepository.findAll(pageable).map(this::toRes);
    }

    private ProductRes toRes(Product p) {
        var imgs = p.getImages().stream().map(ProductImage::getUrl).toList();
        var cats = p.getCategories().stream().map(Category::getId).toList();
        return new ProductRes(p.getId(), p.getName(), p.getDescription(), p.getPrice(), imgs, cats);
    }

}
