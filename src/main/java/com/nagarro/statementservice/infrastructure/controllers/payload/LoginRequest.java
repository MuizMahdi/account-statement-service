package com.nagarro.statementservice.infrastructure.controllers.payload;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
