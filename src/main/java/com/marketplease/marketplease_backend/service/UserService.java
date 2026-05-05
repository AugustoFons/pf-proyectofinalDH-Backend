package com.marketplease.marketplease_backend.service;

import com.marketplease.marketplease_backend.domain.Product;
import com.marketplease.marketplease_backend.repositories.ProductRepository;
import com.marketplease.marketplease_backend.domain.Role;
import com.marketplease.marketplease_backend.domain.User;
import com.marketplease.marketplease_backend.dto.UserDtos.UpdateUserRolesReq;
import com.marketplease.marketplease_backend.dto.UserDtos.UserRes;
import com.marketplease.marketplease_backend.repositories.RoleRepository;
import com.marketplease.marketplease_backend.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ProductRepository productRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.productRepository = productRepository;
    }

    public Page<UserRes> list(int page, int size) {
        var pageable = PageRequest.of(page, Math.min(size, 20), Sort.by(Sort.Direction.ASC, "id"));
        return userRepository.findAll(pageable).map(this::toRes);
    }

    public UserRes updateRoles(Long userId, UpdateUserRolesReq request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + userId));

        Set<Role> resolvedRoles = resolveRoles(request.roles());
        user.setRoles(resolvedRoles);

        User saved = userRepository.save(user);
        return toRes(saved);
    }

    public List<Long> getFavorites(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + email));
        return user.getFavoriteProducts().stream()
                .map(Product::getId)
                .toList();
    }

    public void addFavorite(String email, Long productId) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + email));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado: " + productId));
        user.getFavoriteProducts().add(product);
        userRepository.save(user);
    }

    public void removeFavorite(String email, Long productId) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + email));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado: " + productId));
        user.getFavoriteProducts().remove(product);
        userRepository.save(user);
    }

    private Set<Role> resolveRoles(List<String> roles) {
        Set<Role> resolved = new LinkedHashSet<>();

        for (String roleName : roles) {
            if (roleName == null || roleName.isBlank()) {
                throw new IllegalArgumentException("La lista de roles contiene valores invalidos");
            }

            String normalized = roleName.trim().toUpperCase(Locale.ROOT);
            Role role = roleRepository.findByName(normalized)
                    .orElseThrow(() -> new IllegalArgumentException("Rol no encontrado: " + normalized));
            resolved.add(role);
        }

        return resolved;
    }

    private UserRes toRes(User user) {
        List<String> roles = user.getRoles().stream()
                .map(Role::getName)
                .sorted()
                .toList();

        return new UserRes(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.isEnabled(),
                roles
        );
    }
}