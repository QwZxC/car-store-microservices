package com.example.userservice.domain.exception.types;

public class PersonNotFoundException extends  RuntimeException{

    public PersonNotFoundException() {
        super("Person not found");
    }
}
