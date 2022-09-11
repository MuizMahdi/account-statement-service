package com.nagarro.statementservice.infrastructure.data.entities;

import com.nagarro.statementservice.core.domain.Statement;
import com.nagarro.statementservice.infrastructure.utilities.DateUtils;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "statement")
@Getter
@Setter
public class StatementData {

    @Id
    @Column(name = "ID")
    private Long id;

    private String amount;

    @Column(name = "datefield")
    private String date;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", insertable = false, updatable = false)
    private Account account;*/

    // TODO: Maps Data to Domain, use MapStruct later on instead of manually constructing
    public Statement getStatement() {
        return new Statement(getId(), new BigDecimal(getAmount()), DateUtils.getLocalDate(getDate()));
    }

}
