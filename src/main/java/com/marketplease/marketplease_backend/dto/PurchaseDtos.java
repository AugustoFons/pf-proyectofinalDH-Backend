package com.marketplease.marketplease_backend.dto;

import com.marketplease.marketplease_backend.enums.PurchaseStatus;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PurchaseDtos {

    public record PurchaseCreateReq(
            @NotNull Long productId
    ) {}

    public record PurchaseRes(
            Long id,
            Long productId,
            String productName,
            String productImage,
            Long userId,
            Integer quantity,
            BigDecimal totalPrice,
            PurchaseStatus status,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {}
}
