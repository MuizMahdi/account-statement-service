package com.nagarro.statementservice.infrastructure.controllers;

import com.nagarro.statementservice.core.domain.Statement;
import com.nagarro.statementservice.core.usecases.StatementService;
import com.nagarro.statementservice.infrastructure.controllers.payload.StatementCriteria;
import com.nagarro.statementservice.infrastructure.helpers.constants.Endpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Endpoints.Statement.Resource)
public class StatementController {

    private final StatementService statementService;

    @Autowired
    public StatementController(StatementService statementService) {
        this.statementService = statementService;
    }

    @GetMapping
    public List<Statement> findStatements(@Valid StatementCriteria criteria) {
        return statementService.findByCriteria(criteria);
    }

}
