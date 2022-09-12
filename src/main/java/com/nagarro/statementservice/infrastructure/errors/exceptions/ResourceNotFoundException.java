package com.nagarro.statementservice.infrastructure.errors.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException implements GenericException {
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s was not found with %s: '%s'", resourceName, fieldName, fieldValue));
    }

    @Override
    public HttpStatus getHttpStatus() { return HttpStatus.NOT_FOUND; }
}
