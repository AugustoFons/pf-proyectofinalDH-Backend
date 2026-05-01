package com.marketplease.marketplease_backend.controller;

import com.marketplease.marketplease_backend.dto.ReservationDtos.ReservationCreateReq;
import com.marketplease.marketplease_backend.dto.ReservationDtos.ReservationRes;
import com.marketplease.marketplease_backend.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<ReservationRes> create(Authentication authentication,
                                                @Valid @RequestBody ReservationCreateReq req) {
        ReservationRes created = reservationService.createReservation(authentication.getName(), req);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
