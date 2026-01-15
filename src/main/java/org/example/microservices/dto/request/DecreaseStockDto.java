package org.example.microservices.dto.request;

import jakarta.validation.constraints.NotNull;

public record DecreaseStockDto (
        @NotNull
        Integer stockQuantity
) {
}
