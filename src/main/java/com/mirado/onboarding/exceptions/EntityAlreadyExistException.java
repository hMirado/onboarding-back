package com.mirado.onboarding.exceptions;

public class EntityAlreadyExistException  extends RuntimeException {
    private ErrorCodes errorCodes;

    public EntityAlreadyExistException(String message) {
        super(message);
    }

    public EntityAlreadyExistException(String message, ErrorCodes errorCodes) {
        super(message);
        this.errorCodes = errorCodes;
    }
}
