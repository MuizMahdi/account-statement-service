package com.nagarro.statementservice.infrastructure.errors.handlers;

import com.nagarro.statementservice.infrastructure.errors.pojos.ErrorResponse;

public interface ErrorHandler {
    boolean canHandle(Throwable exception);
    ErrorResponse handle(Throwable exception);
}
