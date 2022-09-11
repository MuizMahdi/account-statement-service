package com.nagarro.statementservice.core.domain;

import java.util.Set;

public interface StatementRepository {
    Set<Statement> findByAccountId(Long accountId);
}
