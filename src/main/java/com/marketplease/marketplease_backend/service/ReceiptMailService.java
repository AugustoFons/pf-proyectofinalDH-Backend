package com.marketplease.marketplease_backend.service;

import com.marketplease.marketplease_backend.dto.ReceiptEmail;
import com.marketplease.marketplease_backend.dto.ReceiptEmail.DetailRow;
import com.marketplease.marketplease_backend.repositories.RoleRepository;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * Construye y envia por correo un comprobante de compra/reserva, replicando el
 * ticket que genera el front en ConfirmActionModal.buildReceiptHtml().
 *
 * El envio es @Async: no demora la respuesta de la API y si el SMTP falla solo
 * se loguea, nunca rompe la compra/reserva ya guardada.
 */
@Service
public class ReceiptMailService {

    private static final Logger log = LoggerFactory.getLogger(ReceiptMailService.class);

    private static final DateTimeFormatter EMITTED_FMT =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    // Etiquetas de estado, iguales a STATUS_LABELS del front.
    private static final Map<String, String> STATUS_LABELS = Map.of(
            "BOOKED", "Reservado",
            "PENDING", "Pendiente",
            "CONFIRMED", "Confirmada",
            "CANCELLED", "Cancelado",
            "REJECTED", "Rechazado"
    );

    private final JavaMailSender mailSender;
    private final RoleRepository roleRepository;

    @Value("${app.mail.from}")
    private String from;

    @Value("${app.mail.enabled:true}")
    private boolean enabled;

    public ReceiptMailService(JavaMailSender mailSender, RoleRepository roleRepository) {
        this.mailSender = mailSender;
        this.roleRepository = roleRepository;
    }

    @Async
    public void sendReceipt(ReceiptEmail receipt) {
        if (!enabled) {
            log.info("Envio de correo deshabilitado (app.mail.enabled=false). Comprobante {} no enviado.",
                    code(receipt.id()));
            return;
        }
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, StandardCharsets.UTF_8.name());
            helper.setFrom(from);
            helper.setTo(receipt.toEmail());
            helper.setSubject("Comprobante de tu " + receipt.type().toLowerCase()
                    + " · " + code(receipt.id()));
            helper.setText(buildHtml(receipt), true);

            mailSender.send(message);
            log.info("Comprobante {} enviado a {}", code(receipt.id()), receipt.toEmail());
        } catch (Exception ex) {
            // Nunca propagar: la compra/reserva ya esta confirmada.
            log.error("No se pudo enviar el comprobante {} a {}: {}",
                    code(receipt.id()), receipt.toEmail(), ex.getMessage());
        }
    }

    // MP-000123, igual que receiptCode() del front.
    private String code(long id) {
        return "MP-" + String.format("%06d", id);
    }

    private String statusLabel(String statusCode) {
        return STATUS_LABELS.getOrDefault(statusCode, statusCode);
    }

    private String providerContact() {
        return roleRepository.findByName("ROLE_ADMIN")
                .map(role -> role.getPhone())
                .orElse(null);
    }

    private String buildHtml(ReceiptEmail r) {
        String code = code(r.id());
        String estado = statusLabel(r.statusCode());
        String emitted = (r.emittedAt() != null ? r.emittedAt() : LocalDateTime.now()).format(EMITTED_FMT);
        String contacto = providerContact();

        StringBuilder rows = new StringBuilder();
        rows.append(row("Titular", r.toName()));
        rows.append(row("Correo", r.toEmail()));
        for (DetailRow dr : r.rows()) {
            rows.append(row(dr.label(), dr.value()));
        }
        rows.append(row("Emitido", emitted));
        if (contacto != null && !contacto.isBlank()) {
            rows.append(row("Contacto proveedor", contacto));
        }

        String imageBlock = (r.imageUrl() != null && r.imageUrl().startsWith("http"))
                ? "<img src=\"" + esc(r.imageUrl()) + "\" alt=\"\" />"
                : "";

        return """
                <!doctype html>
                <html lang="es"><head><meta charset="utf-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1" />
                <title>Comprobante %s</title>
                <style>
                  * { box-sizing: border-box; }
                  body { font-family: -apple-system, "Segoe UI", Roboto, Helvetica, Arial, sans-serif; color: #1f2733; margin: 0; padding: 32px; background: #f4f6fb; }
                  .ticket { max-width: 460px; margin: 0 auto; background: #fff; border: 1px solid #e3e8f0; border-radius: 16px; overflow: hidden; }
                  .head { background: #2563eb; color: #fff; padding: 20px 24px; }
                  .head h1 { font-size: 18px; margin: 0; letter-spacing: .5px; display: inline-block; }
                  .head .code { font-size: 12px; opacity: .9; font-family: ui-monospace, Menlo, monospace; float: right; }
                  .body { padding: 24px; }
                  .badge { display: inline-block; font-size: 12px; font-weight: 700; padding: 4px 10px; border-radius: 999px; background: #ecfdf5; color: #047857; border: 1px solid #a7f3d0; }
                  .product { margin: 16px 0; }
                  .product img { width: 64px; height: 64px; object-fit: cover; border-radius: 10px; border: 1px solid #e3e8f0; vertical-align: middle; margin-right: 14px; }
                  .product .name { font-weight: 700; display: inline-block; vertical-align: middle; }
                  table { width: 100%%; border-collapse: collapse; margin-top: 8px; }
                  th, td { text-align: left; padding: 10px 0; border-bottom: 1px dashed #e3e8f0; font-size: 14px; vertical-align: top; }
                  th { color: #64748b; font-weight: 600; width: 42%%; }
                  td { font-weight: 600; }
                  .foot { padding: 16px 24px 24px; font-size: 12px; color: #64748b; text-align: center; }
                </style></head>
                <body>
                  <div class="ticket">
                    <div class="head">
                      <h1>MarketPlease</h1>
                      <span class="code">%s</span>
                    </div>
                    <div class="body">
                      <span class="badge">%s &middot; %s</span>
                      <div class="product">
                        %s
                        <span class="name">%s</span>
                      </div>
                      <table>
                        %s
                      </table>
                    </div>
                    <div class="foot">Comprobante generado por MarketPlease &middot; Conserva este documento</div>
                  </div>
                </body></html>
                """.formatted(
                code,
                code,
                esc(r.type()), esc(estado),
                imageBlock,
                esc(r.productName()),
                rows.toString()
        );
    }

    private String row(String label, String value) {
        return "<tr><th>" + esc(label) + "</th><td>" + esc(value) + "</td></tr>";
    }

    // Escapa caracteres HTML para no romper la plantilla con nombres/datos arbitrarios.
    private String esc(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }
}
