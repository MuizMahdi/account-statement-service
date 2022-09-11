package com.nagarro.statementservice.core.domain;

import java.util.List;

public interface StatementRepository {
    List<Statement> find();
}
