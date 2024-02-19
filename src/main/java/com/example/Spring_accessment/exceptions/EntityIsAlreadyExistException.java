package com.example.Spring_accessment.exceptions;

public class EntityIsAlreadyExistException extends RuntimeException {

    // Constructor
    public EntityIsAlreadyExistException(String message) {
        super(message);
    }
}
