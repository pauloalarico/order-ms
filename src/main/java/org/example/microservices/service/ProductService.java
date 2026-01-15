package org.example.microservices.service;

import lombok.RequiredArgsConstructor;
import org.example.microservices.dto.request.RequestOrderDTO;
import org.example.microservices.http.ProductClient;
import org.example.microservices.utils.ProductDtoMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductClient productClient;
    private final ProductDtoMapper mapper;

    public void verifyProduct(RequestOrderDTO dto) {
        var productDto = productClient.verifyProduct(String.valueOf(dto.productId()));
        if(productDto.id() == null) {
            throw new RuntimeException("Product not found, or does not exists.");
        }
        decreaseStock(String.valueOf(dto.productId()), dto.quantity());
    }

    private void decreaseStock(String id, Integer quantity) {
        var requestBodyDto = mapper.decreaseStockMapper(quantity);
        productClient.decreaseStock(id, requestBodyDto);
    }
}
