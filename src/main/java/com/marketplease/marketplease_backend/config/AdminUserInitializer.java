package com.marketplease.marketplease_backend.config;

import com.marketplease.marketplease_backend.domain.Role;
import com.marketplease.marketplease_backend.domain.User;
import com.marketplease.marketplease_backend.repositories.RoleRepository;
import com.marketplease.marketplease_backend.repositories.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Component
public class AdminUserInitializer implements ApplicationRunner {

    private static final String DEFAULT_ADMIN_EMAIL = "admin@marketplease.local";
    private static final String DEFAULT_ADMIN_PASSWORD = "password";

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminUserInitializer(UserRepository userRepository,
                                RoleRepository roleRepository,
                                PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) {
        Role roleAdmin = roleRepository.findByName("ROLE_ADMIN")
                .orElseGet(() -> roleRepository.save(new Role(null, "ROLE_ADMIN")));

        Role roleUser = roleRepository.findByName("ROLE_USER")
                .orElseGet(() -> roleRepository.save(new Role(null, "ROLE_USER")));

        String normalizedEmail = DEFAULT_ADMIN_EMAIL.toLowerCase(Locale.ROOT);

        User admin = userRepository.findByEmail(normalizedEmail).orElseGet(User::new);
        admin.setFirstName("Admin");
        admin.setLastName("MarketPlease");
        admin.setEmail(normalizedEmail);
        admin.setEnabled(true);
        admin.setPassword(passwordEncoder.encode(DEFAULT_ADMIN_PASSWORD));

        Set<Role> roles = new HashSet<>();
        roles.add(roleAdmin);
        roles.add(roleUser);
        admin.setRoles(roles);

        userRepository.save(admin);
    }
}
