package com.nagarro.statementservice.persistence.repositories;

import com.nagarro.statementservice.persistence.entities.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Long> {
}
