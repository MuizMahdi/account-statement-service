package com.nagarro.statementservice.infrastructure.controllers;

import com.nagarro.statementservice.core.usecases.AccountService;
import com.nagarro.statementservice.infrastructure.controllers.payload.ApiResponse;
import com.nagarro.statementservice.infrastructure.helpers.constants.Endpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoints.Account.RESOURCE)
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ApiResponse> getAccountWithStatements(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse(true, accountService.findAccountById(id)));
    }

}
