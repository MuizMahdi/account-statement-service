package com.nagarro.statementservice.infrastructure.errors.exceptions;

import org.springframework.http.HttpStatus;

public interface GenericException {
    String getMessage();
    HttpStatus getHttpStatus();
}
