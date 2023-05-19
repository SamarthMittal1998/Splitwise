package com.example.splitwise.exceptions;

/**
 * Created by samarth mittal.
 */
public class GroupNotFoundException extends CustomExceptionHandler {

    private static final long serialVersionUID = 1L;

    public GroupNotFoundException(String message) {
        super(message);
    }
}
