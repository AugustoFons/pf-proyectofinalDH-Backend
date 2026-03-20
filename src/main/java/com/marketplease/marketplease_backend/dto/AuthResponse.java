package com.marketplease.marketplease_backend.dto;

public record AuthResponse(
        String token,
        AuthUserResponse user
) {
}
