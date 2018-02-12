package com.todo.config;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.util.Collections;

public class DataSourceConfig {

    private static final int MAX_TOTAL = 20;
    private static final String INIT_SQL = "select 1;";

    public DataSource DataSource(String url, String login, String password){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(url);
        ds.setUsername(login);
        ds.setPassword(password);
        ds.setMaxTotal(MAX_TOTAL);
        ds.setConnectionInitSqls(Collections.singletonList(INIT_SQL);
        return ds;
    }
}