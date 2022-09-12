package com.nagarro.statementservice.infrastructure.errors.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FieldError {
    private String code;
    private String property;
    private String message;
    private Object rejectedValue;
}
