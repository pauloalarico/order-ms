package org.example.microservices.application.dto.shared.response;

public record ExceptionResponseDto (
        Integer code,
        String message
) {
}
