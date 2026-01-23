package org.example.microservices.presentation.controller.exception;

import feign.FeignException;
import jakarta.validation.ValidationException;
import org.example.microservices.application.dto.response.ExceptionResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionOrganizer {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ExceptionResponseDto> validation(ValidationException e) {
        return ResponseEntity.badRequest().body(new ExceptionResponseDto(4000, e.getMessage()));
    }

    @ExceptionHandler(FeignException.FeignClientException.class)
    public ResponseEntity<ExceptionResponseDto> feignException(FeignException.FeignClientException e) {
        return ResponseEntity.unprocessableContent().body(new ExceptionResponseDto(4004, e.getMessage()));
    }
}
