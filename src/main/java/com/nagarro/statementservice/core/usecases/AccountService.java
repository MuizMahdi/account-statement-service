package com.nagarro.statementservice.core.usecases;

import com.nagarro.statementservice.core.domain.Account;
import com.nagarro.statementservice.core.domain.AccountRepository;
import com.nagarro.statementservice.infrastructure.helpers.utilities.AccountUtils;
import com.nagarro.statementservice.infrastructure.helpers.utilities.StatementUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findAccountById(Long id) {
        Account account = accountRepository.findById(id);

        // Get only statements within the default range
        account.setStatements(StatementUtils.getWithinDefaultDateRange(account.getStatements()));

        // Mask account number
        account.setNumber(AccountUtils.getMaskedAccountNumber(account.getNumber()));

        return account;
    }
}
