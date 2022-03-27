package com.ionnote.exceptions;

public class EventNotFoundException extends Exception {
    public EventNotFoundException() {
        super();
    }

    public EventNotFoundException(String message) {
        super(message);
    }
}
