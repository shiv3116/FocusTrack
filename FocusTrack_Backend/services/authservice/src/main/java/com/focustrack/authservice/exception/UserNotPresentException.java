package com.focustrack.authservice.exception;

public class UserNotPresentException extends RuntimeException{
    public UserNotPresentException(Exception e) {
        super("User Does not exist with given Email Id");
    }
}
