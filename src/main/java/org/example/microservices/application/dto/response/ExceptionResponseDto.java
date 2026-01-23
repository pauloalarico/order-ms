package org.example.microservices.application.dto.response;

public record ExceptionResponseDto (
        Integer code,
        String message
) {
}
