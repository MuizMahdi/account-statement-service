package com.nagarro.statementservice.infrastructure.errors.handlers;

import com.nagarro.statementservice.infrastructure.errors.exceptions.GenericException;
import com.nagarro.statementservice.infrastructure.errors.pojos.ErrorResponse;
import org.springframework.stereotype.Component;

@Component
public class GenericErrorHandler implements ErrorHandler {
    @Override
    public boolean canHandle(Throwable exception) {
        return exception instanceof GenericException;
    }

    @Override
    public ErrorResponse handle(Throwable exception) {
        return new ErrorResponse(((GenericException) exception).getHttpStatus(), exception.getMessage());
    }
}
