package com.mirado.onboarding.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private HttpStatus status;
    private Object errors;

    public static <T> ApiResponse<T> success(T data, String message, HttpStatus status) {
        return new ApiResponse<>(true, message, data, status, null);
    }

    public static <T> ApiResponse<T> error(String message, HttpStatus status, Object errors) {
        return new ApiResponse<>(false, message, null, status, errors);
    }

    public static <T> ApiResponse<T> error(String message, HttpStatus status) {
        return new ApiResponse<>(false, message, null, status, null);
    }
}
