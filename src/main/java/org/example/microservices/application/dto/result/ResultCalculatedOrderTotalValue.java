package org.example.microservices.application.dto.result;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

public record ResultCalculatedOrderTotalValue (
        @NotNull
        UUID correlationId,
        @NotNull
        @Positive
        BigDecimal amount
) {
}
