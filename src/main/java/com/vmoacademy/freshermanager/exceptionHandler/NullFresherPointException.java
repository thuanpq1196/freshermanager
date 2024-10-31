package com.vmoacademy.freshermanager.exceptionHandler;

public class NullFresherPointException extends RuntimeException{
    public NullFresherPointException(String message) {
        super(message);
    }

    public NullFresherPointException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullFresherPointException(Throwable cause) {
        super(cause);
    }
}
