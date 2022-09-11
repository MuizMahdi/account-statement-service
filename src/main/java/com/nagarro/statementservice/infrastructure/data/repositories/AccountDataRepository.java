package com.nagarro.statementservice.infrastructure.data.repositories;

import com.nagarro.statementservice.infrastructure.data.entities.AccountData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDataRepository extends JpaRepository<AccountData, Long> {}
