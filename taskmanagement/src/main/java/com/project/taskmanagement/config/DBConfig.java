package com.project.taskmanagement.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {

    private static final String URL = "jdbc:mysql://localhost:3306/tasksystem_db";
    private static final String USER = "root";
    private static final String PASSWORD = "sql123"; 

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}