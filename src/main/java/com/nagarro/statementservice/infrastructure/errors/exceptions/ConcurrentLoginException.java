package com.nagarro.statementservice.infrastructure.errors.exceptions;

import org.springframework.http.HttpStatus;

public class ConcurrentLoginException extends RuntimeException implements GenericException {
    public ConcurrentLoginException() {
        super("Already authenticated");
    }

    @Override
    public HttpStatus getHttpStatus() { return HttpStatus.UNAUTHORIZED; }
}
