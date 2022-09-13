package com.nagarro.statementservice.infrastructure.data.entities;

import com.nagarro.statementservice.core.domain.Account;
import com.nagarro.statementservice.core.domain.AccountType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "account")
@Getter
@Setter
public class AccountData {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "account_type")
    private String type;

    @Column(name = "account_number")
    private String number;

    @OneToMany
    @JoinColumn(name = "account_id")
    private Set<StatementData> statements;

    public Account getAccount() {
        return new Account(id, AccountType.valueOf(type.toUpperCase()), number,
            statements.stream().map(StatementData::getStatement).collect(Collectors.toSet()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AccountData accountData = (AccountData) o;
        return id != null && Objects.equals(id, accountData.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
