package com.ionnote.exceptions;

public class ForbiddenException extends Exception{
    public ForbiddenException() {
        super();
    }
    public ForbiddenException(String message) {
        super(message);
    }
}
