package org.example.microservices.application.dto.json.product;

import java.util.UUID;

public record ProductSenderDTO(
        UUID correlationId,
        UUID id,
        Integer quantity
) {
}
