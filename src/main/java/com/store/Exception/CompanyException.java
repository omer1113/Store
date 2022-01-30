package com.store.Exception;

public class CompanyException extends Exception{
    public CompanyException() {
        super("General Exception");
    }

    public CompanyException(String message) {
        super(message);
    }
}
