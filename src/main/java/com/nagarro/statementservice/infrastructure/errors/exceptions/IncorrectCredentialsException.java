package com.nagarro.statementservice.infrastructure.errors.exceptions;

import org.springframework.http.HttpStatus;

public class IncorrectCredentialsException extends RuntimeException implements GenericException {
    public IncorrectCredentialsException() {
        super("Incorrect login credentials");
    }

    @Override
    public HttpStatus getHttpStatus() { return HttpStatus.BAD_REQUEST; }
}
