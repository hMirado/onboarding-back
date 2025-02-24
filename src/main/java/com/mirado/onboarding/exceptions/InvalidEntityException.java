package com.mirado.onboarding.exceptions;

import lombok.Getter;

import java.util.List;

@Getter
public class InvalidEntityException extends RuntimeException{
    private ErrorCodes errorCodes;
    private List<String> errors;

    public InvalidEntityException(String message) {
        super(message);
    }

    public InvalidEntityException(String message, Throwable thrwbl) {
        super(message, thrwbl);
    }

    public InvalidEntityException(String message, Throwable thrwbl, ErrorCodes errorCode) {
        super(message, thrwbl);
        this.errorCodes = errorCode;
    }

    public InvalidEntityException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCodes = errorCode;
    }

    public InvalidEntityException(String message, ErrorCodes errorCode, List<String> errors) {
        super(message);
        this.errorCodes = errorCode;
        this.errors = errors;
    }
}
