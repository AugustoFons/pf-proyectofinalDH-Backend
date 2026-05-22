package com.marketplease.marketplease_backend.controller;

import com.marketplease.marketplease_backend.dto.PurchaseDtos.PurchaseCreateReq;
import com.marketplease.marketplease_backend.dto.PurchaseDtos.PurchaseRes;
import com.marketplease.marketplease_backend.service.PurchaseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<PurchaseRes> create(Authentication authentication,
                                              @Valid @RequestBody PurchaseCreateReq req) {
        PurchaseRes created = purchaseService.createPurchase(authentication.getName(), req);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/me")
    public ResponseEntity<List<PurchaseRes>> myPurchases(Authentication authentication) {
        List<PurchaseRes> purchases = purchaseService.getUserPurchases(authentication.getName());
        return ResponseEntity.ok(purchases);
    }
}
