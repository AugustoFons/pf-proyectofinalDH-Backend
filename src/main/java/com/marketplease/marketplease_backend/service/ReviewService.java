package com.marketplease.marketplease_backend.service;

import com.marketplease.marketplease_backend.domain.Product;
import com.marketplease.marketplease_backend.domain.Purchase;
import com.marketplease.marketplease_backend.domain.Reservation;
import com.marketplease.marketplease_backend.domain.Review;
import com.marketplease.marketplease_backend.domain.User;
import com.marketplease.marketplease_backend.dto.ReviewDtos.*;
import com.marketplease.marketplease_backend.enums.ProductType;
import com.marketplease.marketplease_backend.enums.PurchaseStatus;
import com.marketplease.marketplease_backend.enums.ReservationStatus;
import com.marketplease.marketplease_backend.repositories.ProductRepository;
import com.marketplease.marketplease_backend.repositories.PurchaseRepository;
import com.marketplease.marketplease_backend.repositories.ReservationRepository;
import com.marketplease.marketplease_backend.repositories.ReviewRepository;
import com.marketplease.marketplease_backend.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;
    private final PurchaseRepository purchaseRepository;

    public ReviewService(ReviewRepository reviewRepository, ProductRepository productRepository, 
                         UserRepository userRepository, ReservationRepository reservationRepository,
                         PurchaseRepository purchaseRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
        this.purchaseRepository = purchaseRepository;
    }

    public List<ReviewRes> getProductReviews(Long productId) {
        return reviewRepository.findByProductIdOrderByCreatedAtDesc(productId)
                .stream()
                .map(this::toRes)
                .toList();
    }

    public boolean canReview(Long productId, String userEmail) {
        try {
            Product product = productRepository.findById(productId).orElseThrow();
            User user = userRepository.findByEmail(userEmail).orElseThrow();

            if (product.getProductType() == ProductType.VENTA) {
                List<Purchase> userPurchases = purchaseRepository.findByProductIdAndUserId(productId, user.getId());
                return userPurchases.stream()
                        .anyMatch(p -> p.getStatus() == PurchaseStatus.CONFIRMED);
            }
            
            List<Reservation> userReservations = reservationRepository.findByProductIdAndUserId(productId, user.getId());
            return userReservations.stream()
                    .anyMatch(r -> r.getStatus() == ReservationStatus.BOOKED);
        } catch (Exception e) {
            return false;
        }
    }

    public ReviewRes createOrUpdateReview(Long productId, String userEmail, ReviewCreateReq req) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        if (product.getProductType() == ProductType.VENTA) {
            List<Purchase> userPurchases = purchaseRepository.findByProductIdAndUserId(productId, user.getId());
            boolean hasConfirmedPurchase = userPurchases.stream()
                    .anyMatch(p -> p.getStatus() == PurchaseStatus.CONFIRMED);
            
            if (!hasConfirmedPurchase) {
                throw new IllegalArgumentException("Debes tener una compra confirmada de este producto para poder valorarlo.");
            }
        } else {
            // Validate if user has a confirmed reservation for this rent product
            List<Reservation> userReservations = reservationRepository.findByProductIdAndUserId(productId, user.getId());
            
            boolean hasConfirmedReservation = userReservations.stream()
                    .anyMatch(r -> r.getStatus() == ReservationStatus.BOOKED);

            if (!hasConfirmedReservation) {
                throw new IllegalArgumentException("Debes tener una reserva confirmada de este producto para poder valorarlo.");
            }
        }

        Review review = reviewRepository.findByProductIdAndUserId(productId, user.getId())
                .orElseGet(() -> new Review(product, user, req.score(), req.comment()));

        review.setScore(req.score());
        review.setComment(req.comment());
        
        reviewRepository.save(review);
        return toRes(review);
    }

    private ReviewRes toRes(Review review) {
        return new ReviewRes(
                review.getId(),
                review.getProduct().getId(),
                review.getUser().getId(),
                review.getUser().getFirstName() + " " + review.getUser().getLastName(),
                review.getScore(),
                review.getComment(),
                review.getCreatedAt()
        );
    }
}
