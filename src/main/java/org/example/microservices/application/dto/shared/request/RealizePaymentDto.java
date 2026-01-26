package org.example.microservices.application.dto.shared.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

public record RealizePaymentDto (
        @NotNull
        UUID correlationId,
        @NotNull
        @Positive
        BigDecimal amount
){
}
