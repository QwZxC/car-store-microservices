package com.example.userservice.domain.exception.types;

public class UserNotFoundException extends  RuntimeException{

    public UserNotFoundException() {
        super("User not found");
    }
}
