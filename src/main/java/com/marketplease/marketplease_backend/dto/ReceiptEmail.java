package com.marketplease.marketplease_backend.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Datos ya resueltos del comprobante que se envia por correo.
 *
 * Se arma DENTRO de la transaccion (en el service) con valores primitivos para
 * que el envio @Async no tenga que tocar entidades lazy (producto/usuario) en
 * otro hilo. El service de mail se encarga de formatear y construir el HTML.
 */
public record ReceiptEmail(
        String toEmail,
        String toName,
        long id,
        String type,        // "Compra" | "Reserva"
        String statusCode,  // nombre del enum: CONFIRMED, BOOKED, ...
        String productName,
        String imageUrl,     // puede ser null
        List<DetailRow> rows,
        LocalDateTime emittedAt
) {
    public record DetailRow(String label, String value) {}
}
