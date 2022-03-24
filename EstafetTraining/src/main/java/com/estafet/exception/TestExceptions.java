package com.estafet.exception;

import org.junit.Test;

public class TestExceptions {
<<<<<<<< HEAD:EstafetTraining/src/com/estafet/exception/TestExceptions.java
    public static void main(String[] args) {
========

    public void main(String[] args) {
>>>>>>>> origin/Maven:EstafetTraining/src/main/java/com/estafet/exception/TestExceptions.java
        Order ord = new Order();
        //ord.methodSignitureException(8);
        //ord.methodHandleException(8);
        //ord.methodReThrow(3);
        //ord.methodCatchMultipleExceptions();
        //ord.catchThrowableException();
        ord.tryWithResources();
    }
}