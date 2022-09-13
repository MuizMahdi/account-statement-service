package com.nagarro.statementservice.controllers;

import com.nagarro.statementservice.core.domain.Statement;
import com.nagarro.statementservice.core.usecases.StatementService;
import com.nagarro.statementservice.infrastructure.controllers.StatementController;
import com.nagarro.statementservice.infrastructure.controllers.payload.ApiResponse;
import com.nagarro.statementservice.infrastructure.controllers.payload.StatementCriteria;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@RunWith(SpringRunner.class)
public class StatementControllerTest {
    @InjectMocks
    private StatementController statementController;

    @Mock
    private StatementService statementService;

    @Test
    public void testGetStatements() {
        StatementCriteria statementCriteria = new StatementCriteria();
        statementCriteria.setAccountId(1L);

        Set<Statement> statements = Set.of(new Statement(1L, new BigDecimal(23), LocalDate.now()));

        Mockito.when(statementService.findByCriteria(statementCriteria)).thenReturn(statements);

        ResponseEntity<ApiResponse> result = statementController.getStatements(statementCriteria);
        Assert.assertEquals(statements, Objects.requireNonNull(result.getBody()).getData());
    }
}
