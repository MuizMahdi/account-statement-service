package com.nagarro.statementservice.usecases;

import com.nagarro.statementservice.core.domain.Account;
import com.nagarro.statementservice.core.domain.AccountRepository;
import com.nagarro.statementservice.core.domain.AccountType;
import com.nagarro.statementservice.core.domain.Statement;
import com.nagarro.statementservice.core.usecases.AccountService;
import com.nagarro.statementservice.infrastructure.errors.exceptions.ResourceNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import static org.mockito.Mockito.doThrow;

@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest {
    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @Test
    public void testFindAccountById() {
        Set<Statement> accountStatements = Set.of(new Statement(1L, new BigDecimal(23), LocalDate.now()));
        Account returnedAccount = new Account(1L, AccountType.CURRENT, "023412345", accountStatements);

        Mockito.when(accountRepository.findById(1L)).thenReturn(returnedAccount);

        Account result = accountService.findAccountById(1L);
        Assert.assertEquals(returnedAccount, result);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testFindAccountByIdNotFound(){
        doThrow(new ResourceNotFoundException("account", "accountId", 1L)).when(accountRepository).findById(1L);
        accountService.findAccountById(1L);
    }
}
