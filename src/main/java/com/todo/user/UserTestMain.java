package com.todo.user;

import com.todo.config.DataSourceConfig;
import org.apache.commons.dbcp2.BasicDataSource;
import org.flywaydb.core.Flyway;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;

public class UserTestMain {

    public static final String URL = "jdbc:postgresql://localhost:5432/todo";
    public static final String LOGIN = "postgres";
    public static final String PASSWORD = "postgres";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DataSource ds = new DataSourceConfig().DataSource(URL, LOGIN, PASSWORD);
        Flyway flyway = new Flyway();
        flyway.setDataSource(ds);
        flyway.migrate();
        System.out.println(new UserDao(ds).getByLogin("John"));

    }
}
