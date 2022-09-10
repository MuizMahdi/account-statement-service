package com.nagarro.statementservice.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() throws Exception {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:ucanaccess://src/main/resources/data/accountsdb.accdb;showSchema=true");
        dataSource.setDriverClassName("net.ucanaccess.jdbc.UcanaccessDriver");
        return dataSource;
    }

}
