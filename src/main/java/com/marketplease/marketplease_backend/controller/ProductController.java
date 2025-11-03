package com.marketplease.marketplease_backend.controller;

import com.marketplease.marketplease_backend.domain.Product;
import com.marketplease.marketplease_backend.dto.ProductDtos.*;
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
    public Page<ProductRes> list(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size){
        return productService.list(page, size);
    }

    // Listar detalle
    @GetMapping("/{id}")
    public ProductRes getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    // Crear
    @PostMapping
    public ProductRes create(@RequestBody ProductCreateReq product) {
        return productService.create(product);
    }

    // Actualizar
    @PutMapping("/{id}")
    public ProductRes update(@PathVariable Long id, @RequestBody ProductUpdateReq product) {
        return productService.update(id, product);
    }

    // Borrar
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping("/search")
    public Page<ProductRes> search(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   @RequestParam(required = false) String query,
                                   @RequestParam(required = false) Long categoryId) {
        return productService.search(page, size, query, categoryId);
    }

}
