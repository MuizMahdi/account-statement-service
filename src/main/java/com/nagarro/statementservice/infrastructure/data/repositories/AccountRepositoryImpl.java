package com.nagarro.statementservice.infrastructure.data.repositories;

import com.nagarro.statementservice.core.domain.Account;
import com.nagarro.statementservice.core.domain.AccountRepository;
import com.nagarro.statementservice.infrastructure.data.entities.AccountData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private final AccountDataRepository accountDataRepository;

    @Autowired
    public AccountRepositoryImpl(AccountDataRepository accountDataRepository) {
        this.accountDataRepository = accountDataRepository;
    }

    @Override
    public Account findById(Long accountId) {
        Optional<AccountData> accountData = accountDataRepository.findById(accountId);
        // TODO: return proper response with message
        if (accountData.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return accountData.get().getAccount();
    }
}
