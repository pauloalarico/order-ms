package org.example.microservices.json.payment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

public record NewPaymentDto(
        @NotNull
        UUID orderId,
        @NotNull
        @Positive
        BigDecimal amount
) {
}
