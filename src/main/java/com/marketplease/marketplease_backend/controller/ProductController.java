package com.marketplease.marketplease_backend.controller;

import com.marketplease.marketplease_backend.domain.Product;
import com.marketplease.marketplease_backend.dto.ProductDtos;
import com.marketplease.marketplease_backend.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Listar paginados
    @GetMapping
    public Page<ProductDtos.ProductRes> list(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size){
        return productService.list(page, size);
    }

    // Listar detalle
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return null;
    }

    // Crear
    @PostMapping
    public Product create(@RequestBody Product product) {
        return null;
    }

    // Actualizar
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return null;
    }

    // Borrar
    @DeleteMapping
    public void delete(@PathVariable Long id) {
    }


}
