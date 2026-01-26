package org.example.microservices.application.dto.command;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record RequestOrderDTO(
        @NotNull
        UUID productId,
        @NotNull
        Integer quantity
) {
}
