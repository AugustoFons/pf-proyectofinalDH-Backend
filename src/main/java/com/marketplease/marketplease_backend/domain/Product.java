package com.marketplease.marketplease_backend.domain;

import com.marketplease.marketplease_backend.enums.ProductType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products",
        uniqueConstraints = @UniqueConstraint(name="uq_products_name", columnNames = "name"))
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_type", nullable = false )
    private ProductType productType = ProductType.VENTA;

    private BigDecimal price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("position ASC, id ASC")
    private List<ProductImage> images = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("position ASC, id ASC")
    private List<ProductFeature> features = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("position ASC, id ASC")
    private List<ProductPolicy> policies = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new LinkedHashSet<>();

    @org.hibernate.annotations.Formula("(SELECT COALESCE(AVG(r.score), 0.0) FROM reviews r WHERE r.product_id = id)")
    private Double averageRating = 0.0;

    @org.hibernate.annotations.Formula("(SELECT COUNT(r.id) FROM reviews r WHERE r.product_id = id)")
    private Integer reviewCount = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public List<ProductFeature> getFeatures() {
        return features;
    }

    public void setFeatures(List<ProductFeature> features) {
        this.features = features;
    }

    public List<ProductPolicy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<ProductPolicy> policies) {
        this.policies = policies;
    }


    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }
}

