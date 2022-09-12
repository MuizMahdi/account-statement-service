package com.nagarro.statementservice.infrastructure.controllers.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private String message;
    private boolean isSuccessful;
    private Object data;

    public ApiResponse(String message, boolean isSuccessful) {
        this.message = message;
        this.isSuccessful = isSuccessful;
    }

    public ApiResponse(boolean isSuccessful, Object data) {
        this.isSuccessful = isSuccessful;
        this.data = data;
    }
}
