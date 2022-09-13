package com.nagarro.statementservice.usecases;

import com.nagarro.statementservice.core.domain.*;
import com.nagarro.statementservice.core.usecases.StatementService;
import com.nagarro.statementservice.infrastructure.controllers.payload.StatementCriteria;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
public class StatementServiceTest {
    @InjectMocks
    private StatementService statementService;

    @Mock
    private StatementRepository statementRepository;

    @Test
    public void testFindByCriteria() {
        StatementCriteria statementCriteria = new StatementCriteria();
        statementCriteria.setAccountId(1L);

        Set<Statement> statements = Set.of(
            new Statement(1L, new BigDecimal(23), LocalDate.now()),
            new Statement(2L, new BigDecimal(23), LocalDate.now().minusMonths(2)),
            new Statement(3L, new BigDecimal(23), LocalDate.now().minusMonths(3))
        );

        Mockito.when(statementRepository.findByAccountId(1L)).thenReturn(statements);

        Set<Statement> result = statementService.findByCriteria(statementCriteria);
        Set<Statement> expectedStatements = Set.of(new Statement(2L, new BigDecimal(23), LocalDate.now().minusMonths(2)));
        Assert.assertEquals(expectedStatements, result);
    }
}
