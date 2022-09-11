package com.nagarro.statementservice.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Account {
    private Long id;
    private AccountType type;
    private String number;
    private Set<Statement> statements;
}
