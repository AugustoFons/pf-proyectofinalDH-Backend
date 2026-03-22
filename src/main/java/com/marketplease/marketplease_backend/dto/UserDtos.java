package com.marketplease.marketplease_backend.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class UserDtos {

    public record UserRes(
            Long id,
            String firstName,
            String lastName,
            String email,
            boolean enabled,
            List<String> roles
    ) {}

    public record UpdateUserRolesReq(
            @NotNull List<String> roles
    ) {}
}