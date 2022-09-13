package com.nagarro.statementservice.infrastructure.data.repositories;

import com.nagarro.statementservice.core.domain.Statement;
import com.nagarro.statementservice.core.domain.StatementRepository;
import com.nagarro.statementservice.infrastructure.data.entities.StatementData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class StatementRepositoryImpl implements StatementRepository {

    private final StatementDataRepository statementDataRepository;

    @Autowired
    public StatementRepositoryImpl(StatementDataRepository statementDataRepository) {
        this.statementDataRepository = statementDataRepository;
    }

    @Override
    public Set<Statement> findByAccountId(Long accountId) {
        return statementDataRepository.findAllByAccountId(accountId).parallelStream()
            .map(StatementData::getStatement).collect(Collectors.toSet());
    }
}
