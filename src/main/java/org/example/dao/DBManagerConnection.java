package org.example.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.example.exception.DatabaseDriverNotFoundException;
import org.example.exception.WrongParameterException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class DBManagerConnection {

    @Value(value = "${spring.datasource.url}")
    private String url;

    @Value(value = "${spring.datasource.username}")
    private String user;

    @Value(value = "${spring.datasource.password}")
    private String password;

    @Value(value = "${spring.datasource.driver-class-name}")
    private String driver;

    @Bean
    public HikariDataSource dataSource() {
        try {
            Class.forName(driver);
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(url);
            config.setMaximumPoolSize(5);
            config.setUsername(user);
            config.setPassword(password);
            return new HikariDataSource(config);
        } catch (RuntimeException e) {
           throw new WrongParameterException(e);
        } catch (ClassNotFoundException e) {
            throw new DatabaseDriverNotFoundException(e);
        }
    }

    public Connection getConnection() throws SQLException {
        return dataSource().getConnection();
    }
}
