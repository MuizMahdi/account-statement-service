package com.nagarro.statementservice.infrastructure.errors.handlers;

import com.nagarro.statementservice.infrastructure.errors.pojos.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@ControllerAdvice(annotations = RestController.class)
public class GlobalErrorHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalErrorHandler.class);

    private final List<ErrorHandler> handlers;

    public GlobalErrorHandler(List<ErrorHandler> handlers) {
        this.handlers = handlers;
        LOGGER.debug("Error handling is active with handlers: {}", this.handlers);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Throwable exception, WebRequest webRequest) {
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
            LOGGER.debug("Exception Web Request: {}", webRequest);
            LOGGER.error(exception.getMessage(), exception);
        }

        return ResponseEntity.status(errorResponse.getHttpStatus()).body(errorResponse);
    }
}
