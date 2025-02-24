package com.mirado.onboarding.exceptions;

import com.mirado.onboarding.dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerGlobalException {
    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ApiResponse<String>> invalidEntityException(InvalidEntityException ex) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.badRequest().body(ApiResponse.error(ex.getMessage(), HttpStatus.BAD_REQUEST, ex.getErrors()));
    }

    @ExceptionHandler(EntityAlreadyExistException.class)
    public ResponseEntity<ApiResponse<String>> entityAlreadyExistException(EntityAlreadyExistException ex) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ApiResponse.error(ex.getMessage(), HttpStatus.CONFLICT));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGlobalException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("An unexpected error occurred. Please contact administrator", HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
