package com.marketplease.marketplease_backend.controller;

import com.marketplease.marketplease_backend.dto.ProductDtos.*;
import com.marketplease.marketplease_backend.enums.ProductType;
import com.marketplease.marketplease_backend.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
    public ProductRes create(@Valid @RequestBody ProductCreateReq product) {
        return productService.create(product);
    }

    // Actualizar
    @PutMapping("/{id}")
    public ProductRes update(@PathVariable Long id, @Valid @RequestBody ProductUpdateReq product) {
        return productService.update(id, product);
    }

    // Borrar
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        productService.delete(id);
        // Devuelve un estado 200 con un JSON
        return ResponseEntity.ok(Collections.singletonMap("mensaje", "Producto eliminado correctamente"));
    }

    @GetMapping("/search")
    public Page<ProductRes> search(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size,
                                @RequestParam(required = false) String query,
                                @RequestParam(required = false) Long categoryId,
                                @RequestParam(required = false) ProductType productType,
                                @RequestParam(required = false) LocalDate dateFrom,
                                @RequestParam(required = false) LocalDate dateTo) {
        return productService.search(page, size, query, categoryId, productType, dateFrom, dateTo);
    }

    @GetMapping("/suggestions")
    public List<String> suggestions(@RequestParam String q,
                                    @RequestParam(defaultValue = "5") int limit) {
        return productService.suggest(q, limit);
    }

}
