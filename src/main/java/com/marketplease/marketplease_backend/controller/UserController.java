package com.marketplease.marketplease_backend.controller;

import com.marketplease.marketplease_backend.dto.UserDtos.UpdateUserRolesReq;
import com.marketplease.marketplease_backend.dto.UserDtos.UserRes;
import com.marketplease.marketplease_backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Page<UserRes> list(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size) {
        return userService.list(page, size);
    }

    @PutMapping("/{id}/roles")
    public ResponseEntity<UserRes> updateRoles(@PathVariable Long id,
                                               @Valid @RequestBody UpdateUserRolesReq request) {
        UserRes updated = userService.updateRoles(id, request);
        return ResponseEntity.ok(updated);
    }
}