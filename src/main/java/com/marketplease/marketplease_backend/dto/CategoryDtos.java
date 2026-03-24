package com.marketplease.marketplease_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryDtos {
    public record CategoryCreateReq(
            @NotBlank @Size(max = 100) String name
    ) {}

    public record CategoryUpdateReq(
            @NotBlank @Size(max = 100) String name
    ) {}

    public record CategoryRes(Long id, String name) {}
}
