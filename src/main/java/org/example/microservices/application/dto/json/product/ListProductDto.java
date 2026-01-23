package org.example.microservices.application.dto.json.product;

import java.util.List;

public record ListProductDto (
        List<ProductDto> products
){
}
