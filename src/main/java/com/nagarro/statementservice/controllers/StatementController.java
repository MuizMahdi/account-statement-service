package com.nagarro.statementservice.controllers;

import com.nagarro.statementservice.persistence.entities.Statement;
import com.nagarro.statementservice.persistence.repositories.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("statement")
public class StatementController {

    private final StatementRepository statementRepository;

    @Autowired
    public StatementController(StatementRepository statementRepository) {
        this.statementRepository = statementRepository;
    }

    @GetMapping
    public Statement getStatements() {
        List<Statement> statements = statementRepository.findAll();
        return statements.get(0);
    }

}
