package com.marketplease.marketplease_backend.dto;

import com.marketplease.marketplease_backend.enums.ReservationStatus;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservationDtos {

    public record ReservationCreateReq(
            @NotNull Long productId,
            @NotNull LocalDate dateFrom,
            @NotNull LocalDate dateTo
    ) {}

    public record ReservationRes(
            Long id,
            Long productId,
            Long userId,
            LocalDate dateFrom,
            LocalDate dateTo,
            ReservationStatus status,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {}
}
