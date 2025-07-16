package com.focustrack.authservice.exception;

public class UserNotRegisteredException extends RuntimeException{
    public UserNotRegisteredException(Exception e) {
        super("User Not Registered Successfully");
    }
}
