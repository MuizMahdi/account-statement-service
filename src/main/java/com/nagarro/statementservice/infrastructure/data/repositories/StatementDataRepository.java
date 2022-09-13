package com.nagarro.statementservice.infrastructure.data.repositories;

import com.nagarro.statementservice.infrastructure.data.entities.StatementData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatementDataRepository extends JpaRepository<StatementData, Long> {
    List<StatementData> findAllByAccountId(Long accountId);
}
