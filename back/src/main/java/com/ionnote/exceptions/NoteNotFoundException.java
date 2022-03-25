package com.ionnote.exceptions;

public class NoteNotFoundException extends Exception {
    public NoteNotFoundException() {
        super();
    }

    public NoteNotFoundException(String message) {
        super(message);
    }
}

