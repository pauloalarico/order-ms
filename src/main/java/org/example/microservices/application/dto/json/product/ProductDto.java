package org.example.microservices.application.dto.json.product;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record ProductDto(
        @JsonProperty("productId")
        String id,
        BigDecimal price,
        Integer stockQuantity   

) {
}
