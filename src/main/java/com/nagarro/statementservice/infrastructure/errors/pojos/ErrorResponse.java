package com.nagarro.statementservice.infrastructure.errors.pojos;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ErrorResponse {

    private final HttpStatus httpStatus;
    private final String message;
    private final List<FieldError> fieldErrors;

    public ErrorResponse(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.fieldErrors = new ArrayList<>();
    }

    public void addFieldError(FieldError fieldError) {
        fieldErrors.add(fieldError);
    }

}
