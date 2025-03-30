package com.example.homework03.exception;

public class NotFoundExceptionHandler extends RuntimeException {

    public NotFoundExceptionHandler(String message) {
        super(message);
    }
}
