package com.nagarro.statementservice.persistence.entities;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Statement {

    @Id
    @Column(name = "ID")
    private Long id;

    private BigDecimal amount;

    @Column(name = "datefield")
//    @DateTimeFormat(pattern = "dd.mm.yyyy")
    private String date;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", insertable = false, updatable = false)
    private Account account;*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Statement statement = (Statement) o;
        return id != null && Objects.equals(id, statement.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
