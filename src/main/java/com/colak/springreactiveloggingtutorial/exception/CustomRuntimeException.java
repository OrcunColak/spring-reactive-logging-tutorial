package com.colak.springreactiveloggingtutorial.exception;


public class CustomRuntimeException extends RuntimeException {

    public CustomRuntimeException(Throwable e, String msg) {
        super(msg, e);
    }
}
