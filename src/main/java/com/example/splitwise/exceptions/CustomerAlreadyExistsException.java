package com.example.splitwise.exceptions;

/**
 * Created by samarth mittal.
 */
public class CustomerAlreadyExistsException extends CustomExceptionHandler {

    private static final long serialVersionUID = 1L;

    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
