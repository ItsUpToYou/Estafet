package com.estafet.exception;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrdersManager implements IManager {
    static ResultSetHandler<List<Orders>> rsh = new BeanListHandler<>(Orders.class);
    static QueryRunner run = new QueryRunner();

    /**
     * Chekc if the table exist in the DataBase, if not will be created.
     */
    public static void checkIfDBTableExist(String tableName) {

        try (Connection con = DataBaseOracle.getConnection()) {
            boolean isTableExist = con.prepareStatement(String.format(createTableSQL, tableName)).executeQuery().next();

            // Create tableName
            if (isTableExist != true) {
                run.update(con, String.format(sqlQeury, tableName));
                System.out.println("Table is created");
            } else {
                System.out.println("DB Table exist.");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }


    /**
     * Order objects should be stored in the db when created.
     * If table doesn't exist - creation script should be executed
     */
    public static void createOrderObjToDB(Orders obj) {
        checkIfDBTableExist("ORDERS");

        //Sql Insert for the obj
        try (Connection conn = DataBaseOracle.getConnection()) {

            // Execute the SQL update statement
            run.execute(conn, String.format(insertInto, obj.getFirstName(), obj.getLastName(), obj.getCity(), obj.getAddress(), obj.getEmail(), obj.getItemQuantity(), obj.getTotalPrice()), rsh);
            System.out.println("The new data is inserted.");

            //get Orders_ID
            try (PreparedStatement pst = conn.prepareStatement(String.format(sqlGetOrders_ID, obj.getFirstName(), obj.getLastName()))) {
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {

                    obj.setOrders_id((rs.getInt("Orders_Id")));
                    System.out.println("Order_sId is : " + obj.getOrders_id());

                } else {
                    System.out.println("records Orders_ID is not found");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Order objects should be updated also in the db when updated
     */
    public static void updateOrderDb(Orders obj) {
        try (Connection conn = DataBaseOracle.getConnection()) {

            // Execute the SQL update statement
            run.update(conn, String.format(updateObj, obj.getFirstName(), obj.getLastName(), obj.getCity(), obj.getAddress(), obj.getEmail(), obj.getItemQuantity(), obj.getTotalPrice(), obj.getOrders_id()));
            System.out.println(obj.getOrders_id());
            System.out.println("The new data was updated.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Order objects should be deleted also in the db when deleted
     */
    public static void deleteOrderDB(Orders obj) {
        try (Connection conn = DataBaseOracle.getConnection()) {

            //Delete given obj from the Database
            run.execute(conn, String.format(deleteOrderFromDB, obj.getFirstName(), obj.getLastName()), rsh);
            System.out.println("The object with name " + obj.getFirstName() + " " + obj.getLastName() + " were deleted .");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Create methods for retrieving and loading all Orders in a list
     */
    public static List<Orders> getAllOrders() {

        //get all orders from the Database
        List<Orders> ordersLst = null;
        try (Connection conn = DataBaseOracle.getConnection()) {

            //retrieving information from the DB
            ordersLst = run.query(conn, getAllOrdersQuery, rsh);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Printing retrieved data
        ordersLst.stream().forEach(s -> System.out.println(s.getFirstName()
                + " | " + s.getLastName()
                + " | " + s.getCity()
                + " | " + s.getAddress()
                + " | " + s.getEmail()
                + " | " + s.getItemQuantity()
                + " | " + s.getTotalPrice()
                + " | " + s.getDateTime()));
        return ordersLst;
    }


    /**
     * Create methods for retrieving and loading Orders in a list
     * using different parameters (by id, date range and etc)
     */

    public static <T> List<Orders> getOrdersBy(ColumnNames columnName, T t) {

        //get all orders from the Database
        List<Orders> ordersLst = null;
        try (Connection conn = DataBaseOracle.getConnection()) {

            //retrieving information from the DB
            ordersLst = run.query(conn, String.format(getBySQL, columnName, t), rsh);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ordersLst.forEach(s -> System.out.println(s.getFirstName()
                + " | " + s.getLastName()
                + " | " + s.getCity()
                + " | " + s.getAddress()
                + " | " + s.getEmail()
                + " | " + s.getItemQuantity()
                + " | " + s.getTotalPrice()
                + " | " + s.getDateTime()));
        return ordersLst;
    }

    public static <T> List<Orders> getOrdersBy(ColumnNames columnName, T min, T max) {

        //get all orders from the Database
        List<Orders> ordersLst = null;
        try (Connection conn = DataBaseOracle.getConnection()) {

            //retrieving information from the DB
            ordersLst = run.query(conn, String.format(getBySQLBetween, columnName, min, max), rsh);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ordersLst.forEach(s -> System.out.println(s.getFirstName()
                + " | " + s.getLastName()
                + " | " + s.getCity()
                + " | " + s.getAddress()
                + " | " + s.getEmail()
                + " | " + s.getItemQuantity()
                + " | " + s.getTotalPrice()
                + " | " + s.getDateTime()));
        return ordersLst;
    }

    /**
     * Get the count of all the Orders
     */
    public static int countAllOrders() {

        int rowCount = 0;
        try (Connection con = DataBaseOracle.getConnection()) {

            //get counted rows in the DataBase with column index
            ResultSet rs = con.prepareStatement(selectAllFromOrders).getResultSet();
            rs.next();
            rowCount = rs.getInt(1);
            System.out.println("Number of DB rows is : " + rowCount);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }


    /**
     * Get the count of the Orders that meet conditions set as parameters to the method
     */
    public static <T> int countResultsBetween(ColumnNames columnName, T min, T max) {
        int rowCount = 0;
        try (Connection con = DataBaseOracle.getConnection()) {
            String sql = String.format(countResultsBetween, columnName, min, max);
            //get counted rows in the DataBase with column index
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            rs.next();
            rowCount = rs.getInt(1);
            System.out.println("Number of DB rows is : " + rowCount);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }
}
