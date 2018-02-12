package com.todo.user;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;

public class UserTestMain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        System.out.println(new UserDao(ds).getByLogin("John"));

    }
}
