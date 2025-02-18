package com.example.teste_maxiprod.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Person Not Found in the DataBase")
public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException(String id){
        super("Person with id: " + id + " Not Found");
    }

}
