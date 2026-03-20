package com.marketplease.marketplease_backend.service;
import com.marketplease.marketplease_backend.domain.Role;
import com.marketplease.marketplease_backend.domain.User;
import com.marketplease.marketplease_backend.dto.AuthResponse;
import com.marketplease.marketplease_backend.dto.AuthUserResponse;
import com.marketplease.marketplease_backend.dto.LoginRequest;
import com.marketplease.marketplease_backend.dto.RegisterRequest;
import com.marketplease.marketplease_backend.exception.ConflictException;
import com.marketplease.marketplease_backend.repositories.RoleRepository;
import com.marketplease.marketplease_backend.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService,
                       AuthenticationManager authenticationManager) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse register(RegisterRequest request) {

        String normalizedEmail = request.getEmail().trim().toLowerCase(Locale.ROOT);

        if (userRepository.existsByEmail(normalizedEmail)) {
            throw new ConflictException("El email ya esta registrado");
        }

        Role roleUser = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new IllegalStateException("No existe el rol base ROLE_USER"));

        Set<Role> roles = new HashSet<>();
        roles.add(roleUser);

        User user = new User();
        user.setFirstName(request.getFirstName().trim());
        user.setLastName(request.getLastName().trim());
        user.setEmail(normalizedEmail);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(roles);

        User savedUser = userRepository.save(user);
        String token = jwtService.generateToken(savedUser);

        return new AuthResponse(token, toAuthUser(savedUser));
    }

    public AuthResponse login(LoginRequest request) {
        String normalizedEmail = request.getEmail().trim().toLowerCase(Locale.ROOT);

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        normalizedEmail,
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(normalizedEmail)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        String token = jwtService.generateToken(user);
        return new AuthResponse(token, toAuthUser(user));
    }

    public AuthUserResponse getCurrentUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        return toAuthUser(user);
    }

    private AuthUserResponse toAuthUser(User user) {
        List<String> roles = user.getRoles().stream().map(Role::getName).sorted().toList();
        return new AuthUserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), roles);
    }
}