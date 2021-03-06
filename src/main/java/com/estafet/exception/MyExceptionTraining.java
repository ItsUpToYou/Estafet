package com.estafet.exception;

import java.io.*;
import java.util.Scanner;

import static java.lang.System.err;

public class MyExceptionTraining {


    //- On some of the methods in class Order (method X) mark that they will throw that custom exception (in the method signature)
    public void methodSignitureException() throws CustomException {
            throw new CustomException("Custom exception in thrown");
    }

    // From another method, call X and handle the exception
    public void methodHandleException() {
        try {
            methodSignitureException();
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }

    //From another method call X and re-throw the exception
    public void methodReThrowException() throws CustomException {
        methodSignitureException();
    }

    //- Clear resources in the finally block
    public void methodClear() {
        FileInputStream inputStream = null;
        try {
            File file = new File("./tmp.txt");
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //- Catch multiple exceptions
    public void methodCatchMultipleExceptions() {
        try {
            String fileName = "";
            Scanner in = new Scanner(new File(fileName));
            String input = in.next();
            int value = Integer.parseInt(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException n) {
            System.out.println("Input was not a number");
        }
    }



    //Catch the top level exception (Throwable)
    public void catchThrowableException() {
        try {
            throwableMethod();
        } catch (Exception ex) {
            ex.printStackTrace();
            err.println("Throwable- suppressed exceptions:" + ex.getSuppressed()[0]);
        }

    }


    public static void accessResource() {
        throw new RuntimeException("Is not accessable that resource !!!");
    }

    public static void close() throws Exception {
        throw new NullPointerException("Suppressed  Null pointer exception for clear resources. !!");
    }

    public static void throwableMethod() throws Exception {
        Throwable th = null;
        try {
            accessResource();
        } catch (Exception e) {
            th = e;
        } finally {
            try {
                close();
            } catch (Exception e) {
                if (th != null) {
                    e.addSuppressed(th); //Add to primary exception
                    throw e;
                }
            }
        }
    }
    //- Use try with resources on some of the methods of the Order class
    public void tryWithResources() {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            while ((line = br.readLine()) != null) {
                System.out.println("Line =>" + line);
            }
        } catch (IOException e) {
            System.out.println("IOException in try block =>" + e.getMessage());
        }
    }


}
