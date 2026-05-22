package com.marketplease.marketplease_backend.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class ReviewDtos {

    public record ReviewCreateReq(
            @NotNull @Min(1) @Max(5) Integer score,
            @Size(max = 1000) String comment
    ) {}

    public record ReviewRes(
            Long id,
            Long productId,
            Long userId,
            String username,
            Integer score,
            String comment,
            LocalDateTime createdAt
    ) {}
}
