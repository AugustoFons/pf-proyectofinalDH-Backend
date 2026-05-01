package com.marketplease.marketplease_backend.dto;
import com.marketplease.marketplease_backend.enums.ProductType;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ProductDtos {

        public record FeatureReq(
            @NotBlank @Size(max = 60) String icon,
            @NotBlank @Size(max = 200) String label
    ) {}

    public record FeatureRes(String icon, String label) {}

    public record ProductCreateReq(
            @NotBlank @Size(max = 150) String name,
            @Size(max = 10_000) String description,
            @PositiveOrZero BigDecimal price,
            @NotNull ProductType productType,
            @Size(max = 10) List<@NotBlank String> imageUrls,
            List<@NotNull Long> categoryIds,
            List<FeatureReq> features
    ) {}

    public record ProductUpdateReq(
            @NotBlank @Size(max = 150) String name,
            @Size(max = 10_000) String description,
            @PositiveOrZero BigDecimal price,
            @NotNull ProductType productType,
            @Size(max = 20) List<@NotBlank String> imageUrls,
            List<@NotNull Long> categoryIds,
            List<FeatureReq> features
    ) {}

    public record ProductRes(
            Long id, String name, String description,
            BigDecimal price,
            ProductType productType,
            List<String> images,
            List<Long> categories,
            List<FeatureRes> features
    ) {}

    public record DateRangeRes(LocalDate from, LocalDate to) {}

    public record ProductAvailabilityRes(
            Long productId,
            LocalDate from,
            LocalDate to,
            List<DateRangeRes> booked,
            List<DateRangeRes> available
    ) {}
}
