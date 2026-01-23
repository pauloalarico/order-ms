package org.example.microservices.application.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

public record RealizePaymentDto (
        @NotNull
        UUID orderId,
        @NotNull
        @Positive
        BigDecimal amount
){
}
