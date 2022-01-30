package com.store.Exception;

public class ProductException extends Exception{
    public ProductException() {
        super("General Exception");
    }

    public ProductException(String message) {
        super(message);
    }
}
