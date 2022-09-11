package com.nagarro.statementservice.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Statement {
    private Long id;
    private BigDecimal amount;
    private LocalDate creationDate;
}
