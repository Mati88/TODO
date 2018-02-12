package com.todo.task;

import com.todo.user.User;
import com.todo.user.UserMapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static java.lang.String.format;

public class TaskDao {


    public static final String BY_LOGIN = "select * from users where login = '%s'";
    public static final String FIND_ALL = "select * from user";
    public static final String INSERT = "insert into tasks(name) values('%s')";
    public static final String MARK_COMPLETED = "update tasks set completed_by= %s, " +
            "completed_at= now() where id = %s";
    public static final String REMOVE_COMPLETED = "delete from tasks where completed_by is not NULL";

    private Connection connection;
    private UserMapper mapper;

    public TaskDao(Connection connection) {
        this.connection = connection;
        this.mapper = new UserMapper();
    }


    public List<User> find() throws SQLException {
        return mapper.getList(connection.createStatement().executeQuery(FIND_ALL));
    }

    public void save(String name) throws SQLException {
        connection.createStatement().executeUpdate(format(INSERT, name));
    }

    public void markAsDone(Long taskId, Long userId) throws SQLException {
        connection.createStatement().executeUpdate(format(MARK_COMPLETED, userId, taskId));
    }

    public void removeCompleted() throws SQLException {
        connection.createStatement().executeUpdate(REMOVE_COMPLETED);
    }
}
