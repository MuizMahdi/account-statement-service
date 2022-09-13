package com.nagarro.statementservice.core.usecases;

import com.nagarro.statementservice.core.domain.Statement;
import com.nagarro.statementservice.core.domain.StatementRepository;
import com.nagarro.statementservice.infrastructure.controllers.payload.StatementCriteria;
import com.nagarro.statementservice.infrastructure.helpers.utilities.StatementUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class StatementService {

    private final StatementRepository statementRepository;

    @Autowired
    public StatementService(StatementRepository statementRepository) {
        this.statementRepository = statementRepository;
    }

    public Set<Statement> findByCriteria(StatementCriteria criteria) {
        Set<Statement> accountStatements = statementRepository.findByAccountId(criteria.getAccountId());

        // Filter by amount range if set
        if (criteria.hasAmountRange()) {
            accountStatements = StatementUtils.getWithinAmountRange(accountStatements, criteria.getFromAmount(),
                criteria.getToAmount());
        }

        // Filter by date range if set
        if (criteria.hasDateRange()) {
            accountStatements = StatementUtils.getWithinDateRange(accountStatements, criteria.getFromDate(),
                criteria.getToDate());
        }

        return accountStatements;
    }

}
