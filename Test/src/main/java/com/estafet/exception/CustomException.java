package com.estafet.exception;

public class CustomException extends Exception {
    public CustomException(String str) {
        super(str);
    }

    public CustomException(String str, Exception e) {
        super(str);
    }
}
