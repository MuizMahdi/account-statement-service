package com.nagarro.statementservice.usecases;

import com.nagarro.statementservice.core.domain.Account;
import com.nagarro.statementservice.core.domain.AccountRepository;
import com.nagarro.statementservice.core.domain.AccountType;
import com.nagarro.statementservice.core.domain.Statement;
import com.nagarro.statementservice.core.usecases.AccountService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @Test
    void testFindAccountById() {
        Set<Statement> accountStatements = Set.of(new Statement(1L, new BigDecimal(23), LocalDate.now()));
        Account returnedAccount = new Account(1L, AccountType.CURRENT, "023412345", accountStatements);

        Mockito.when(accountRepository.findById(1L)).thenReturn(returnedAccount);

        Account result = accountService.findAccountById(1L);
        Assert.assertEquals(returnedAccount, result);
    }
}
