package com.example.uhdc.error;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

public enum StatusEnum {
    OK(HttpStatus.OK, "200", "OK", "", "uhdc.error"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "404", "Not Found", "exception", "uhdc.error"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "401", "Unauthorized", "exception", "uhdc.error");
//    BAD_REQUEST(400, "BAD_REQUEST"),
//    NOT_FOUND(404, "NOT_FOUND"),
//    INTERNAL_SERER_ERROR(500, "INTERNAL_SERVER_ERROR");

    private static final StatusEnum[] VALUES;

    static {
        VALUES = values();
    }

    HttpStatus httpStatus;
    String messageCode;
    String message;
    String exception;
    String propagation;

    StatusEnum(HttpStatus httpStatus, String messageCode, String message, String exception, String propagation) {
        this.httpStatus = httpStatus;
        this.messageCode = messageCode;
        this.message = message;
        this.exception = exception;
        this.propagation = propagation;
    }

    public ResponseData getResponseData() {
        return new ResponseData(this.httpStatus.value(), this.messageCode, this.message, this.exception, this.propagation);
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public static StatusEnum valueOf(int statusCode) {
        StatusEnum status = resolve(statusCode);
        if (status == null) {
            throw new IllegalArgumentException("No matching constant for [" + statusCode + "]");
        }
        return status;
    }

    @Nullable
    public static StatusEnum resolve(int statusCode) {
        // Use cached VALUES instead of values() to prevent array allocation.
        for (StatusEnum status : VALUES) {
            if (status.httpStatus.value() == statusCode) {
                return status;
            }
        }
        return null;
    }
}