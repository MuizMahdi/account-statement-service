package com.nagarro.statementservice.infrastructure.controllers.payload;

import com.nagarro.statementservice.infrastructure.helpers.constants.StatementConstants;
import com.nagarro.statementservice.infrastructure.helpers.utilities.DateUtils;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public final class StatementCriteria {
    @NotNull(message = "Account ID is required")
    private Long accountId;

    @DateTimeFormat(pattern=DateUtils.DATE_FORMAT)
    private LocalDate fromDate;

    @DateTimeFormat(pattern=DateUtils.DATE_FORMAT)
    private LocalDate toDate;

    private BigDecimal fromAmount;

    private BigDecimal toAmount;



    public StatementCriteria() {
        // Set default date range if no optional properties were set
        if (!hasCriteria()) {
            fromDate = LocalDate.now().minusMonths(StatementConstants.DEFAULT_STATEMENTS_MONTHS_RANGE);
            toDate = LocalDate.now();
        }
    }

    /**
     * Returns whether amount range was set or not
     */
    public boolean hasAmountRange() {
        return fromAmount != null && toAmount != null;
    }

    /**
     * Returns whether date range was set or not
     */
    public boolean hasDateRange() {
        return fromDate != null && toDate != null;
    }

    /**
     * @return Whether any of the optional criteria are set or not
     */
    private boolean hasCriteria() {
        return hasAmountRange() || hasDateRange();
    }
}
