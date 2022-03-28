package com.estafet.exception;

import org.junit.Test;

public class TestExceptions {

    public static void main(String[] args) {

        Order ord = new Order();
        //ord.methodSignitureException(8);
        //ord.methodHandleException(8);
        //ord.methodReThrow(3);
        //ord.methodCatchMultipleExceptions();
        //ord.catchThrowableException();
        ord.tryWithResources();
    }
}