package org.example.microservices.application.dto.result;

import java.util.UUID;

public record ResultQuantityToRestock(
        UUID correlationId,
        Integer quantity
) {
}
