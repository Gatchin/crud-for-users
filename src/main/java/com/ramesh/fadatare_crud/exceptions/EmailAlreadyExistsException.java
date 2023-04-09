package com.ramesh.fadatare_crud.exceptions;

public class EmailAlreadyExistsException extends RuntimeException{
    private String message;

    public EmailAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
