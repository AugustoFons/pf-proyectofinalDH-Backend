package com.marketplease.marketplease_backend.controller;

import com.marketplease.marketplease_backend.dto.UserDtos.UpdateUserRolesReq;
import com.marketplease.marketplease_backend.dto.UserDtos.UserRes;
import com.marketplease.marketplease_backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @GetMapping("/{email}/favorites")
    public ResponseEntity<List<Long>> getFavorites(@PathVariable String email, java.security.Principal principal) {
        if (!email.equals(principal.getName())) return ResponseEntity.status(org.springframework.http.HttpStatus.FORBIDDEN).build();
        return ResponseEntity.ok(userService.getFavorites(email));
    }

    @PostMapping("/{email}/favorites/{productId}")
    public ResponseEntity<Void> addFavorite(@PathVariable String email, @PathVariable Long productId, java.security.Principal principal) {
        if (!email.equals(principal.getName())) return ResponseEntity.status(org.springframework.http.HttpStatus.FORBIDDEN).build();
        userService.addFavorite(email, productId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{email}/favorites/{productId}")
    public ResponseEntity<Void> removeFavorite(@PathVariable String email, @PathVariable Long productId, java.security.Principal principal) {
        if (!email.equals(principal.getName())) return ResponseEntity.status(org.springframework.http.HttpStatus.FORBIDDEN).build();
        userService.removeFavorite(email, productId);
        return ResponseEntity.noContent().build();
    }
}