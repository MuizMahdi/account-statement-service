package com.nagarro.statementservice.infrastructure.data.entities;

import com.nagarro.statementservice.core.domain.Statement;
import com.nagarro.statementservice.infrastructure.helpers.utilities.DateUtils;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", insertable = false, updatable = false)
    private AccountData account;

    // TODO: Maps Data to Domain, use MapStruct later on instead of manually constructing
    public Statement getStatement() {
        return new Statement(id, new BigDecimal(amount), DateUtils.getLocalDate(date));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StatementData that = (StatementData) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
