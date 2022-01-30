package com.store.Exception;

public class CustomerException extends Exception{
    public CustomerException() {
        super("General Exception");
    }

    public CustomerException(String message) {
        super(message);
    }
}
