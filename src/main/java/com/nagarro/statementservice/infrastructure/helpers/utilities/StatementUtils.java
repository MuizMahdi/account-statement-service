package com.nagarro.statementservice.infrastructure.helpers.utilities;

import com.nagarro.statementservice.core.domain.Statement;
import com.nagarro.statementservice.infrastructure.helpers.constants.StatementConstants;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.compare.ComparableUtils.is;

public class StatementUtils {
    public static Set<Statement> getWithinAmountRange(Set<Statement> statements, BigDecimal min, BigDecimal max) {
        return statements.stream().filter(statement -> is(statement.getAmount()).between(min, max))
                .collect(Collectors.toSet());
    }

    public static Set<Statement> getWithinDateRange(Set<Statement> statements, LocalDate start, LocalDate end) {
        return statements.stream().filter(statement ->
            statement.getCreationDate().isAfter(start) && statement.getCreationDate().isBefore(end)
        ).collect(Collectors.toSet());
    }

    public static Set<Statement> getWithinDefaultDateRange(Set<Statement> statements) {
        LocalDate currentDate = LocalDate.now();
        return statements.stream().filter(statement ->
            statement.getCreationDate().isAfter(currentDate.minusMonths(StatementConstants.DEFAULT_STATEMENTS_MONTHS_RANGE)) &&
            statement.getCreationDate().isBefore(currentDate)
        ).collect(Collectors.toSet());
    }
}
