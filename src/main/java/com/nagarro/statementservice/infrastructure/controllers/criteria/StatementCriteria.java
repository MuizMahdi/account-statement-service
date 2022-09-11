package com.nagarro.statementservice.infrastructure.controllers.criteria;

import com.nagarro.statementservice.infrastructure.utilities.DateUtils;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public final class StatementCriteria {
    @NotBlank(message = "Account ID is required")
    @NotNull
    @Min(0)
    private Long accountId;

    @DateTimeFormat(pattern=DateUtils.DATE_FORMAT)
    private LocalDate fromDate;

    @DateTimeFormat(pattern=DateUtils.DATE_FORMAT)
    private LocalDate toDate;

    private BigDecimal fromAmount;

    private BigDecimal toAmount;

    public StatementCriteria() {
        // Set default date range if there are no amount range and date range criteria set
        if (!hasCriteria()) {
            fromDate = LocalDate.now().minusMonths(3);
            toDate = LocalDate.now();
        }
    }

    /**
     * @return Whether any of the optional criteria are set or not
     */
    private boolean hasCriteria() {
        return (fromAmount != null && toAmount != null) || (fromDate != null && toDate != null);
    }
}
