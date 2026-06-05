package com.marketplease.marketplease_backend.controller;

import com.marketplease.marketplease_backend.dto.ContactDtos.ContactPhoneRes;
import com.marketplease.marketplease_backend.repositories.RoleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * iniciar un chat de WhatsApp. El número vive en el rol ROLE_ADMIN.
 */
@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

    private final RoleRepository roleRepository;

    public ContactController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping("/whatsapp")
    public ContactPhoneRes whatsapp() {
        String phone = roleRepository.findByName("ROLE_ADMIN")
                .map(role -> role.getPhone())
                .orElse(null);
        return new ContactPhoneRes(phone);
    }
}
