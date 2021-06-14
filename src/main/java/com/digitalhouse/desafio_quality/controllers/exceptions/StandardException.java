package com.digitalhouse.desafio_quality.controllers.exceptions;

import org.springframework.http.HttpStatus;

public class StandardException {
    private HttpStatus status;
    private String message;

    public StandardException() {
    }

    public StandardException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
