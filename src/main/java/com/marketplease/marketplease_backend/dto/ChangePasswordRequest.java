package com.marketplease.marketplease_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ChangePasswordRequest {

    @NotBlank(message = "La contrasena actual es obligatoria")
    @Size(min = 6, max = 80, message = "La contrasena actual debe tener entre 6 y 80 caracteres")
    private String currentPassword;

    @NotBlank(message = "La nueva contrasena es obligatoria")
    @Size(min = 6, max = 80, message = "La nueva contrasena debe tener entre 6 y 80 caracteres")
    private String newPassword;

    @NotBlank(message = "La confirmacion de contrasena es obligatoria")
    @Size(min = 6, max = 80, message = "La confirmacion debe tener entre 6 y 80 caracteres")
    private String confirmPassword;

    public ChangePasswordRequest() {}

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}