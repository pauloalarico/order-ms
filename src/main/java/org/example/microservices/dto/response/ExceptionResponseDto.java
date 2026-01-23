package org.example.microservices.dto.response;

public record ExceptionResponseDto (
        Integer code,
        String message
) {
}
