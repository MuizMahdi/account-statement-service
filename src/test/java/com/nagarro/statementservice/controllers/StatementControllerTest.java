package com.nagarro.statementservice.controllers;

import com.nagarro.statementservice.core.domain.Statement;
import com.nagarro.statementservice.core.usecases.StatementService;
import com.nagarro.statementservice.infrastructure.controllers.StatementController;
import com.nagarro.statementservice.infrastructure.controllers.payload.ApiResponse;
import com.nagarro.statementservice.infrastructure.controllers.payload.StatementCriteria;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class StatementControllerTest {
    @InjectMocks
    private StatementController statementController;

    @Mock
    private StatementService statementService;

    @Test
    void testGetStatements() {
        StatementCriteria statementCriteria = new StatementCriteria();
        statementCriteria.setAccountId(1L);

        Set<Statement> statements = Set.of(new Statement(1L, new BigDecimal(23), LocalDate.now()));

        Mockito.when(statementService.findByCriteria(statementCriteria)).thenReturn(statements);

        ResponseEntity<ApiResponse> result = statementController.getStatements(statementCriteria);
        Assert.assertEquals(statements, Objects.requireNonNull(result.getBody()).getData());
    }
}
