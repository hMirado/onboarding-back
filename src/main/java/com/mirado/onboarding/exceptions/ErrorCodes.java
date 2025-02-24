package com.mirado.onboarding.exceptions;

public enum ErrorCodes {
    CUSTOMER_COMPANY_ALREADY_EXIST(1000),
    CUSTOMER_NOT_VALID(1001),
    CUSTOMER_NOT_FOUND(1002),
    SHAREHOLDER_NOT_VALID(2000),
    SHAREHOLDER_NOT_FOUND(2002),
    STATUS_NOT_FOUND(3002)
    ;

    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
