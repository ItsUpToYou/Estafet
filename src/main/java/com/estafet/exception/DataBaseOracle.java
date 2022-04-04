package com.estafet.exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseOracle {
    //connection details
    public static final String serverName = "localhost";
    public static final String port = "1521";
    public static final String dataBase = "orclcdb";
    public static final String username = "sys as sysdba";
    public static final String password = "Oradoc_db1";
    public static final String url = "jdbc:oracle:thin:@" + serverName + ":" + port + ":" + dataBase;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
