package com.example.splitwise.exceptions;

/**
 * Created by samarth mittal.
 */
public class CustomerNotFoundException extends CustomExceptionHandler {

    private static final long serialVersionUID = 1L;

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
