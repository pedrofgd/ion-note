package com.ionnote.exceptions;

public class TaskNotFoundException extends Exception{
    public TaskNotFoundException(){
        super();
    }

    public TaskNotFoundException(String message){
        super(message);
    }
}
