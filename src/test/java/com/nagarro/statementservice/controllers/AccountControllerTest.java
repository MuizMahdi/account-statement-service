package com.nagarro.statementservice.controllers;

import com.nagarro.statementservice.core.domain.Account;
import com.nagarro.statementservice.core.domain.AccountType;
import com.nagarro.statementservice.core.domain.Statement;
import com.nagarro.statementservice.core.usecases.AccountService;
import com.nagarro.statementservice.infrastructure.controllers.AccountController;
import com.nagarro.statementservice.infrastructure.controllers.payload.ApiResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class AccountControllerTest {
    @InjectMocks
    private AccountController accountController;

    @Mock
    private AccountService accountService;

    @Test
    void testGetAccountWithStatements() {
        Set<Statement> accountStatements = Set.of(new Statement(1L, new BigDecimal(23), LocalDate.now()));
        Account returnedAccount = new Account(1L, AccountType.CURRENT, "023412345", accountStatements);

        Mockito.when(accountService.findAccountById(1L)).thenReturn(returnedAccount);

        ResponseEntity<ApiResponse> result = accountController.getAccountWithStatements(1L);
        Assert.assertEquals(returnedAccount, Objects.requireNonNull(result.getBody()).getData());
    }
}
