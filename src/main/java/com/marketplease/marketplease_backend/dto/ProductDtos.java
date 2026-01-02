package com.marketplease.marketplease_backend.dto;
import com.marketplease.marketplease_backend.enums.ProductType;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

public class ProductDtos {
    public record ProductCreateReq(
            @NotBlank @Size(max = 150) String name,
            @Size(max = 10_000) String description,
            @PositiveOrZero BigDecimal price,
            @NotNull ProductType productType,
            @Size(max = 10) List<@NotBlank String> imageUrls,
            List<@NotNull Long> categoryIds
    ) {}

    public record ProductUpdateReq(
            @NotBlank @Size(max = 150) String name,
            @Size(max = 10_000) String description,
            @PositiveOrZero BigDecimal price,
            @NotNull ProductType productType,
            @Size(max = 20) List<@NotBlank String> imageUrls,
            List<@NotNull Long> categoryIds
    ) {}

    public record ProductRes(
            Long id, String name, String description,
            BigDecimal price,
            ProductType productType,
            List<String> images,
            List<Long> categories
    ) {}
}
