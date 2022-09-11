package com.nagarro.statementservice.infrastructure.data.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Account {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Account account = (Account) o;
        return id != null && Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
