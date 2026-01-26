package org.example.microservices.application.dto.shared.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record RequestOrderDTO(
        @NotNull
        UUID productId,
        @NotNull
        Integer quantity
) {
}
