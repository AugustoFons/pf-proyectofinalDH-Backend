package com.marketplease.marketplease_backend.service;

import com.marketplease.marketplease_backend.domain.Product;
import com.marketplease.marketplease_backend.domain.Reservation;
import com.marketplease.marketplease_backend.domain.User;
import com.marketplease.marketplease_backend.dto.ProductDtos.DateRangeRes;
import com.marketplease.marketplease_backend.dto.ProductDtos.ProductAvailabilityRes;
import com.marketplease.marketplease_backend.dto.ReservationDtos.ReservationCreateReq;
import com.marketplease.marketplease_backend.dto.ReservationDtos.ReservationRes;
import com.marketplease.marketplease_backend.enums.ProductType;
import com.marketplease.marketplease_backend.enums.ReservationStatus;
import com.marketplease.marketplease_backend.exception.ConflictException;
import com.marketplease.marketplease_backend.repositories.ProductRepository;
import com.marketplease.marketplease_backend.repositories.ReservationRepository;
import com.marketplease.marketplease_backend.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private static final List<ReservationStatus> BLOCKING_STATUSES = List.of(
            ReservationStatus.PENDING,
            ReservationStatus.BOOKED
    );

    private final ReservationRepository reservationRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ReservationService(ReservationRepository reservationRepository,
                              ProductRepository productRepository,
                              UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public ProductAvailabilityRes getProductAvailability(Long productId, LocalDate from, LocalDate to) {
        Product product = productRepository.findById(productId).orElseThrow(() -> notFoundProduct(productId));
        ensureReservableProduct(product);

        LocalDate windowFrom = from != null ? from : LocalDate.now();
        LocalDate windowTo = to != null ? to : windowFrom.plusMonths(12);
        validateRange(windowFrom, windowTo);

        List<DateRangeRes> bookedRanges = reservationRepository
                .findOverlappingInWindow(productId, windowFrom, windowTo, BLOCKING_STATUSES)
                .stream()
                .map(r -> new DateRangeRes(
                        maxDate(r.getDateFrom(), windowFrom),
                        minDate(r.getDateTo(), windowTo)
                ))
                .filter(r -> r.to().isAfter(r.from()))
                .toList();

        List<DateRangeRes> mergedBookedRanges = mergeRanges(bookedRanges);
        List<DateRangeRes> availableRanges = invertRanges(windowFrom, windowTo, mergedBookedRanges);

        return new ProductAvailabilityRes(
                product.getId(),
                windowFrom,
                windowTo,
                mergedBookedRanges,
                availableRanges
        );
    }

    public ReservationRes createReservation(String email, ReservationCreateReq req) {
        validateRange(req.dateFrom(), req.dateTo());
        if (req.dateFrom().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La reserva no puede comenzar en una fecha pasada");
        }

        Product product = productRepository.findById(req.productId()).orElseThrow(() -> notFoundProduct(req.productId()));
        ensureReservableProduct(product);

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + email));

        boolean hasOverlap = reservationRepository.existsOverlap(
                product.getId(),
                req.dateFrom(),
                req.dateTo(),
                BLOCKING_STATUSES
        );
        if (hasOverlap) {
            throw new ConflictException("Las fechas seleccionadas no estan disponibles");
        }

        Reservation reservation = new Reservation();
        reservation.setProduct(product);
        reservation.setUser(user);
        reservation.setDateFrom(req.dateFrom());
        reservation.setDateTo(req.dateTo());
        reservation.setStatus(ReservationStatus.BOOKED);

        Reservation saved = reservationRepository.save(reservation);
        return toRes(saved);
    }

    private ReservationRes toRes(Reservation r) {
        return new ReservationRes(
                r.getId(),
                r.getProduct().getId(),
                r.getUser().getId(),
                r.getDateFrom(),
                r.getDateTo(),
                r.getStatus(),
                r.getCreatedAt(),
                r.getUpdatedAt()
        );
    }

    private void validateRange(LocalDate from, LocalDate to) {
        if (!to.isAfter(from)) {
            throw new IllegalArgumentException("La fecha de fin debe ser posterior a la fecha de inicio");
        }
    }

    private void ensureReservableProduct(Product product) {
        if (product.getProductType() != ProductType.RESERVA) {
            throw new IllegalArgumentException("Solo los productos de tipo RESERVA permiten disponibilidad");
        }
    }

    private EntityNotFoundException notFoundProduct(Long productId) {
        return new EntityNotFoundException("Producto no encontrado: " + productId);
    }

    private LocalDate minDate(LocalDate a, LocalDate b) {
        return a.isBefore(b) ? a : b;
    }

    private LocalDate maxDate(LocalDate a, LocalDate b) {
        return a.isAfter(b) ? a : b;
    }

    private List<DateRangeRes> mergeRanges(List<DateRangeRes> ranges) {
        if (ranges.isEmpty()) {
            return List.of();
        }

        List<DateRangeRes> sorted = ranges.stream()
                .sorted((a, b) -> a.from().compareTo(b.from()))
                .toList();

        List<DateRangeRes> merged = new ArrayList<>();
        DateRangeRes current = sorted.get(0);

        for (int i = 1; i < sorted.size(); i++) {
            DateRangeRes next = sorted.get(i);
            if (!next.from().isAfter(current.to())) {
                LocalDate newTo = next.to().isAfter(current.to()) ? next.to() : current.to();
                current = new DateRangeRes(current.from(), newTo);
            } else {
                merged.add(current);
                current = next;
            }
        }

        merged.add(current);
        return merged;
    }

    private List<DateRangeRes> invertRanges(LocalDate from, LocalDate to, List<DateRangeRes> occupied) {
        List<DateRangeRes> available = new ArrayList<>();
        LocalDate cursor = from;

        for (DateRangeRes range : occupied) {
            if (cursor.isBefore(range.from())) {
                available.add(new DateRangeRes(cursor, range.from()));
            }
            if (cursor.isBefore(range.to())) {
                cursor = range.to();
            }
        }

        if (cursor.isBefore(to)) {
            available.add(new DateRangeRes(cursor, to));
        }

        return available;
    }
}
