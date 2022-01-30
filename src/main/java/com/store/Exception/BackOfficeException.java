package com.store.Exception;

public class BackOfficeException extends Exception{
    public BackOfficeException() {
        super("General Exception");
    }

    public BackOfficeException(String message) {
        super(message);
    }
}
