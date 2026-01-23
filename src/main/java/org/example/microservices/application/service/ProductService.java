package org.example.microservices.application.service;

import lombok.RequiredArgsConstructor;
import org.example.microservices.application.dto.request.RequestOrderDTO;
import org.example.microservices.http.ProductClient;
import org.example.microservices.application.dto.json.product.ProductDto;
import org.example.microservices.utils.ProductDtoMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductClient productClient;
    private final ProductDtoMapper mapper;

    private void verifyProduct(RequestOrderDTO dto) {
        var productDto = productClient.verifyProduct(String.valueOf(dto.productId()));
        if(productDto.id() == null) {
            throw new RuntimeException("Product not found, or does not exists.");
        }
    }

     public ProductDto decreaseStock(RequestOrderDTO dto) {
        verifyProduct(dto);
        var requestBodyDto = mapper.decreaseStockMapper(dto.quantity());
        var responseBodyDto = productClient.decreaseStock((dto.productId()), requestBodyDto);
        return responseBodyDto.products().getFirst();
    }

    public void resetOrderProductStock(UUID uuid, Integer quantity) {
        productClient.resetProductQuantityByOrder(uuid, quantity);
    }
}
