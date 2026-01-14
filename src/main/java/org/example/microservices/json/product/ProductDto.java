package org.example.microservices.json.product;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record ProductDto(
        @JsonProperty("productId")
        String id,
        BigDecimal price,
        Integer stockQuantity

) {
}
