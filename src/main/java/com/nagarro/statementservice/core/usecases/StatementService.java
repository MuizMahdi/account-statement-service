package com.nagarro.statementservice.core.usecases;

import com.nagarro.statementservice.core.domain.Statement;
import com.nagarro.statementservice.core.domain.StatementRepository;
import com.nagarro.statementservice.infrastructure.controllers.criteria.StatementCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StatementService {

    private StatementRepository statementRepository;

    @Autowired
    public StatementService(StatementRepository statementRepository) {
        this.statementRepository = statementRepository;
    }

    public List<Statement> findAll(StatementCriteria criteria) {
        return statementRepository.find();
    }

}
