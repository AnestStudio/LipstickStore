package org.anest.mystore.exception;

public class ProductNotFoundException extends Exception {

    private int code;
    private String message;

    public ProductNotFoundException() {
    }
}
