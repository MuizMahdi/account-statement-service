package com.nagarro.statementservice.infrastructure.errors.handlers;

import com.nagarro.statementservice.infrastructure.errors.pojos.ErrorResponse;
import com.nagarro.statementservice.infrastructure.errors.pojos.FieldError;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public class FieldErrorHandler implements ErrorHandler {

    @Override
    public boolean canHandle(Throwable exception) {
        return exception instanceof BindingResult;
    }

    @Override
    public ErrorResponse handle(Throwable exception) {
        BindingResult bindingResult = (BindingResult) exception;
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST, getMessage(bindingResult));

        // Add field errors to error response
        if (bindingResult.hasFieldErrors()) {
            bindingResult.getFieldErrors().stream().map(fieldError -> new FieldError(fieldError.getCode(),
                fieldError.getField(), fieldError.getDefaultMessage(), fieldError.getRejectedValue()))
                    .forEach(response::addFieldError);
        }

        return response;
    }

    private String getMessage(BindingResult bindingResult) {
        return String.format("Validation failed for %s", bindingResult.getObjectName());
    }
}
