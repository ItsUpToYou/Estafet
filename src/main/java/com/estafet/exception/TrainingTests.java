package com.estafet.exception;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.jdbc.datasource.DataSourceUtils;
import javax.sql.DataSource;

import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class TrainingTests {

    public static void main(String[] args) throws SQLException {
        //connection details
        String serverName = "localhost";
        String port = "1521";
        String dataBase = "orclcdb";
        String username = "sys as sysdba";
        String password = "Oradoc_db1";
        String url = "jdbc:oracle:thin:@" + serverName + ":" + port + ":" + dataBase;


        //DataBase connection with Oracle
        try ( Connection conn = DriverManager.getConnection(url, username, password) ) {
            System.out.println(" DB Connected...");

            ResultSetHandler<List<Orders>> rsh = new BeanListHandler<Orders>(Orders.class);

            QueryRunner run = new QueryRunner();
            List<Orders> ordersLst = run.query(conn,"SELECT orders_id as orders_id," +
                    " First_Name as firstName," +
                    " Last_Name as lastName," +
                    " City as city," +
                    " Address as address," +
                    " Email as email," +
                    " Item_quantity as itemQuantity," +
                    " Total_price as totalPrice," +
                    " DateTime as dateTime " +
                    " FROM Orders", rsh);
            System.out.println(ordersLst);
        }

//        MyExceptionTraining myExcept  = new MyExceptionTraining();
//        myExcept.methodSignitureException();
//        myExcept.methodHandleException();
//        myExcept.methodReThrowException();
//        myExcept.methodCatchMultipleExceptions();
//        myExcept.catchThrowableException();
//        myExcept.tryWithResources();
    }
}