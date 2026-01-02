package com.marketplease.marketplease_backend.service;

import com.marketplease.marketplease_backend.domain.Category;
import com.marketplease.marketplease_backend.domain.Product;
import com.marketplease.marketplease_backend.domain.ProductImage;
import com.marketplease.marketplease_backend.dto.ProductDtos.*;
import com.marketplease.marketplease_backend.enums.ProductType;
import com.marketplease.marketplease_backend.repositories.CategoryRepository;
import com.marketplease.marketplease_backend.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;

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

    public ProductRes getById(Long id) {
        return productRepository.findById(id).map(this::toRes).orElse(null);
    }

    public ProductRes create(ProductCreateReq product) {
        var p = new Product();
        applyFields(
                p,
                product.name(),
                product.description(),
                product.price(),
                product.productType(),
                product.imageUrls(),
                product.categoryIds()
        );
        var saved = productRepository.save(p);
        return toRes(saved);
    }

    public ProductRes update (Long id, ProductUpdateReq product) {
        var p = productRepository.findById(id).orElseThrow(() -> notFound(id));
        if (productRepository.existsByNameIgnoreCaseAndIdNot(product.name(), id)) {
            throw new IllegalArgumentException("El nombre ya existe: " + product.name());
        }
        p.getImages().clear();
        p.getCategories().clear();

        applyFields(
                p,
                product.name(),
                product.description(),
                product.price(),
                product.productType(),
                product.imageUrls(),
                product.categoryIds()
        );
        var saved = productRepository.save(p);
        return toRes(saved);
    }

    public void delete(Long id) {
        var p = productRepository.findById(id).orElseThrow(() -> notFound(id));
        productRepository.delete(p);
    }

    public Page<ProductRes> search(int page, int size, String q, Long categoryId) {
        var pageable = PageRequest.of(page, Math.min(size, 10), Sort.by(Sort.Direction.DESC, "id"));
        String query = (q == null || q.isBlank()) ? null : q.trim();
        return productRepository.search(query, categoryId, pageable).map(this::toRes);
    }

    private ProductRes toRes(Product p) {
        var imgs = p.getImages().stream().map(ProductImage::getUrl).toList();
        var cats = p.getCategories().stream().map(Category::getId).toList();
        return new ProductRes(
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getPrice(),
                p.getProductType(),
                imgs,
                cats
        );
    }

    private void applyFields(Product p, String name, String description,
                             java.math.BigDecimal price, ProductType productType, List<String> imageUrls, List<Long> categoryIds) {
        p.setName(name);
        p.setDescription(description);
        p.setPrice(price);
        p.setProductType(productType);

        if (imageUrls != null) {
            int pos = 0;
            for (var url : imageUrls) {
                var img = new ProductImage();
                img.setProduct(p);
                img.setUrl(url);
                img.setPosition(pos++);
                p.getImages().add(img);
            }
        }
        if (categoryIds != null && !categoryIds.isEmpty()) {
            var cats = new LinkedHashSet<>(categoryRepository.findByIdIn(categoryIds));
            p.getCategories().addAll(cats);
        }
    }

    private RuntimeException notFound(Long id) {
        return new EntityNotFoundException("Producto no encontrado: " + id);
    }

}
