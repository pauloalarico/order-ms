package org.example.microservices.application.dto.shared.request;

import jakarta.validation.constraints.NotNull;

public record DecreaseStockDto (
        @NotNull
        Integer stockQuantity
) {
}
