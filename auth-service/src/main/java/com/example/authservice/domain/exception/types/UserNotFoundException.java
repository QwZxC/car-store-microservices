package com.example.authservice.domain.exception.types;

public class UserNotFoundException extends  RuntimeException{

    public UserNotFoundException() {
        super("User not found");
    }
}
