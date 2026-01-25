package org.example.microservices.application.dto.json.payment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

public record NewPaymentDto(
        @NotNull
        UUID correlationId,
        @NotNull
        @Positive
        BigDecimal amount
) {
}
