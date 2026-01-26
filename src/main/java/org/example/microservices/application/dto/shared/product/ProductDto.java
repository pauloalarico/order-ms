package org.example.microservices.application.dto.shared.product;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record ProductDto(
        String correlationId,
        @JsonProperty("productId")
        String id,
        BigDecimal price,
        Integer stockQuantity

) {
}
