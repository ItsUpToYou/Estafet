package com.estafet.exception;

import org.hibernate.criterion.Order;

import java.util.List;

public interface IManager {

    String selectAllFromOrders = "SELECT COUNT(*) FROM ORDERS";
    String createTableSQL = "SELECT * FROM dba_tables where table_name = '%s'";
    String countResultsBetween = "SELECT COUNT(*) FROM Orders WHERE %s BETWEEN '%s' AND '%s'";
    String deleteOrderFromDB = "DELETE FROM SYS.ORDERS  WHERE FIRST_NAME = '%s' AND LAST_NAME = '%s'";
    String sqlGetOrders_ID = "SELECT ORDERS_ID FROM SYS.ORDERS WHERE First_Name = '%s' AND  Last_Name = '%s'";
    String insertInto = "INSERT INTO SYS.ORDERS (FIRST_NAME, LAST_NAME, CITY, Address, Email, ITEM_QUANTITY, TOTAL_PRICE) VALUES ('%s', '%s', '%s', '%s', '%s', %d, %d)";

    String updateObj = "UPDATE SYS.ORDERS SET " +
            " FIRST_NAME = '%s'," +
            " LAST_NAME = '%s'," +
            " CITY = '%s'," +
            " Address = '%s'," +
            " Email = '%s'," +
            " ITEM_QUANTITY = %d," +
            " TOTAL_PRICE = %d " +
            " WHERE ORDERS_ID = %d";


    String getAllOrdersQuery = "SELECT orders_id as orders_id," +
            " First_Name as firstName," +
            " Last_Name as lastName," +
            " City as city," +
            " Address as address," +
            " Email as email," +
            " Item_quantity as itemQuantity," +
            " Total_price as totalPrice," +
            " DateTime as dateTime " +
            " FROM Orders";

    String getBySQL = "SELECT orders_id as orders_id," +
            " First_Name as firstName," +
            " Last_Name as lastName," +
            " City as city," +
            " Address as address," +
            " Email as email," +
            " Item_quantity as itemQuantity," +
            " Total_price as totalPrice," +
            " DateTime as dateTime " +
            " FROM Orders WHERE  %s = '%s'";

    String getBySQLBetween = "SELECT orders_id as orders_id," +
            " First_Name as firstName," +
            " Last_Name as lastName," +
            " City as city," +
            " Address as address," +
            " Email as email," +
            " Item_quantity as itemQuantity," +
            " Total_price as totalPrice," +
            " DateTime as dateTime " +
            " FROM Orders WHERE  %s  BETWEEN  '%s' AND '%s' ";

    String sqlQeury = "CREATE TABLE SYS.%s (\"ORDERS_ID\" NUMBER GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 99999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE NOKEEP NOSCALE ," +
            " \"FIRST_NAME\" VARCHAR2(50 BYTE) NOT NULL," +
            " \"LAST_NAME\" VARCHAR2(50 BYTE)NOT NULL," +
            " \"CITY\" VARCHAR2(50 BYTE)NOT NULL," +
            " \"ADDRESS\" VARCHAR2(50 BYTE)NOT NULL," +
            " \"EMAIL\" VARCHAR2(50 BYTE)NOT NULL," +
            " \"ITEM_QUANTITY\" NUMBER NOT NULL," +
            " \"TOTAL_PRICE\" NUMBER NOT NULL," +
            " \"DATETIME\" DATE DEFAULT CURRENT_TIMESTAMP )";
}
