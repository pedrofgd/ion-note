package com.ionnote.constants;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseConstants {
    SUCCESS("SUCCESS"),
    EVENT_NOT_FOUND("EVENT NOT FOUND"),
    USER_NOT_FOUND("USER NOT FOUND"),
    NOTE_NOT_FOUND("NOTE NOT FOUND"),
    TASK_NOT_FOUND("TASK NOT FOUND"),
    UNKNOWN_ERROR("UNKNOWN ERROR"),
    UNAUTHORIZED("UNAUTHORIZED"),
    FORBIDDEN("FORBIDDEN"),
    USER_DISABLED("USER DISABLED"),
    INVALID_CREDENTIALS("INVALID CREDENTIALS");

    private final String message;

}
