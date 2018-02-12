package com.todo.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;

public class UserDao {

    public static final String SELECT_FROM_USERS_WHERE_LOGIN_S = "select * from users where login = '%s'";
    private Connection connection;
    private UserMapper mapper;

    public UserDao(Connection connection) {
        this.connection = connection;
        this.mapper = new UserMapper();
    }

    public User getByLogin(String login) throws SQLException {
        ResultSet res = connection.createStatement().executeQuery(
                String.format(SELECT_FROM_USERS_WHERE_LOGIN_S, login)
        );
        if(!res.next()) throw new NoSuchElementException();
        return mapper.getSingle(res);
    }
}
