package com.nagarro.statementservice.persistence.repositories;

import com.nagarro.statementservice.persistence.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
