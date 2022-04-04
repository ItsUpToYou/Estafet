package com.estafet.exception;

import java.sql.SQLException;


public class TrainingTests {

    public static void main(String[] args) throws SQLException {


        Orders obj = new OrdersBuilder()
                .setFirstName("David")
                .setLastName("Brost")
                .setCity("SeaTropic")
                .setAddress("Islands")
                .setEmail("MailBo")
                .setItemQuantity(4)
                .setTotalPrice(5)
                .build();

//       OrdersManager.createOrderObjToDB(obj);
//        obj.setCity("Varna");
//        OrdersManager.updateOrderDb(obj);
//        OrdersManager.deleteOrderDB(obj);
//        OrdersManager.getAllOrders();
//        OrdersManager.getOrdersBy(ColumnNames.Item_Quantity, 3);
//        OrdersManager.getOrdersBy(ColumnNames.Item_Quantity, 2,4);
//        OrdersManager.countAllOrders();
        OrdersManager.countResultsBetween(ColumnNames.Item_Quantity,3,4);


//        MyExceptionTraining myExcept  = new MyExceptionTraining();
//        myExcept.methodSignitureException();
//        myExcept.methodHandleException();
//        myExcept.methodReThrowException();
//        myExcept.methodCatchMultipleExceptions();
//        myExcept.catchThrowableException();
//        myExcept.tryWithResources();
    }
}