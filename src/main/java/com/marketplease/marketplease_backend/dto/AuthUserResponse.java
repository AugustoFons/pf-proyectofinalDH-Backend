package com.marketplease.marketplease_backend.dto;

import java.util.List;

public record AuthUserResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        List<String> roles
) {
}
