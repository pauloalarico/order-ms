package org.example.microservices.application.dto.request;

import jakarta.validation.constraints.NotNull;

public record DecreaseStockDto (
        @NotNull
        Integer stockQuantity
) {
}
