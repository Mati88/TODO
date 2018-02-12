package com.todo.task;

import com.todo.user.User;
import com.todo.user.UserMapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;

public class TaskDao {

    public static final String SELECT_FROM_USERS_WHERE_LOGIN_S = "select * from tasks where task_name = '%s'";
    private Connection connection;
    private UserMapper mapper;

    public TaskDao(Connection connection) {
        this.connection = connection;
        this.mapper = new UserMapper();
    }

    public User getByTask(String task) throws SQLException {
        ResultSet res = connection.createStatement().executeQuery(
                String.format(SELECT_FROM_USERS_WHERE_LOGIN_S, task)
        );
        if(!res.next()) throw new NoSuchElementException();
        return mapper.getSingle(res);
    }
}
