package com.marketplease.marketplease_backend.controller;

import com.marketplease.marketplease_backend.dto.ReviewDtos.*;
import com.marketplease.marketplease_backend.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{productId}/reviews")
    public ResponseEntity<List<ReviewRes>> getProductReviews(@PathVariable Long productId) {
        return ResponseEntity.ok(reviewService.getProductReviews(productId));
    }

    @GetMapping("/{productId}/reviews/can-review")
    public ResponseEntity<Boolean> canReview(@PathVariable Long productId, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.ok(false);
        }
        return ResponseEntity.ok(reviewService.canReview(productId, userDetails.getUsername()));
    }

    @PostMapping("/{productId}/reviews")
    public ResponseEntity<ReviewRes> createOrUpdateReview(
            @PathVariable Long productId,
            @AuthenticationPrincipal UserDetails userDetails,
            @Valid @RequestBody ReviewCreateReq req) {
        if (userDetails == null) {
            return ResponseEntity.status(403).build();
        }
        ReviewRes res = reviewService.createOrUpdateReview(productId, userDetails.getUsername(), req);
        return ResponseEntity.ok(res);
    }
}
