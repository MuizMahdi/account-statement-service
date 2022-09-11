package com.nagarro.statementservice.infrastructure.data.repositories;

import com.nagarro.statementservice.infrastructure.data.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
