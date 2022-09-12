package com.nagarro.statementservice.infrastructure.errors.handlers;

import com.nagarro.statementservice.infrastructure.errors.pojos.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Locale;

@ControllerAdvice(annotations = RestController.class)
public class GlobalErrorHandler {

    private final List<ErrorHandler> handlers;

    public GlobalErrorHandler(List<ErrorHandler> handlers) {
        this.handlers = handlers;
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(Throwable exception, WebRequest webRequest, Locale locale) {
        ErrorResponse errorResponse = null;

        // Handle known exceptions
        for (ErrorHandler handler : handlers) {
            if (handler.canHandle(exception)) {
                errorResponse = handler.handle(exception);
                break;
            }
        }

        // Unhandled/unknown exceptions
        if (errorResponse == null) {
            errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An unknown error has occurred");
        }

        return ResponseEntity.status(errorResponse.getHttpStatus()).body(errorResponse);
    }
}
