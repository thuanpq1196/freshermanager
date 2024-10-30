package com.vmoacademy.freshermanager.exceptionHandler;

public class FresherNotFoundException extends RuntimeException{
    public FresherNotFoundException(String message) {
        super(message);
    }

    public FresherNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FresherNotFoundException(Throwable cause) {
        super(cause);
    }
}
