package com.marketplease.marketplease_backend.service;

import com.marketplease.marketplease_backend.domain.Product;
import com.marketplease.marketplease_backend.domain.Purchase;
import com.marketplease.marketplease_backend.domain.User;
import com.marketplease.marketplease_backend.dto.PurchaseDtos.PurchaseCreateReq;
import com.marketplease.marketplease_backend.dto.PurchaseDtos.PurchaseRes;
import com.marketplease.marketplease_backend.enums.ProductType;
import com.marketplease.marketplease_backend.enums.PurchaseStatus;
import com.marketplease.marketplease_backend.repositories.ProductRepository;
import com.marketplease.marketplease_backend.repositories.PurchaseRepository;
import com.marketplease.marketplease_backend.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public PurchaseService(PurchaseRepository purchaseRepository,
                           ProductRepository productRepository,
                           UserRepository userRepository) {
        this.purchaseRepository = purchaseRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public PurchaseRes createPurchase(String email, PurchaseCreateReq req) {
        Product product = productRepository.findById(req.productId())
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado: " + req.productId()));

        if (product.getProductType() != ProductType.VENTA) {
            throw new IllegalArgumentException("Solo los productos de tipo VENTA permiten compras directas");
        }

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + email));

        Purchase purchase = new Purchase();
        purchase.setProduct(product);
        purchase.setUser(user);
        purchase.setQuantity(1);
        purchase.setTotalPrice(product.getPrice());
        purchase.setStatus(PurchaseStatus.CONFIRMED);

        Purchase saved = purchaseRepository.save(purchase);
        return toRes(saved);
    }

    public List<PurchaseRes> getUserPurchases(String email) {
        return purchaseRepository.findByUserEmailOrderByCreatedAtDesc(email)
                .stream()
                .map(this::toRes)
                .toList();
    }

    private PurchaseRes toRes(Purchase p) {
        String firstImage = p.getProduct().getImages().isEmpty()
                ? null
                : p.getProduct().getImages().get(0).getUrl();

        return new PurchaseRes(
                p.getId(),
                p.getProduct().getId(),
                p.getProduct().getName(),
                firstImage,
                p.getUser().getId(),
                p.getQuantity(),
                p.getTotalPrice(),
                p.getStatus(),
                p.getCreatedAt(),
                p.getUpdatedAt()
        );
    }
}
