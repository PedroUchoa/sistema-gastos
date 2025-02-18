package com.example.teste_maxiprod.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Persons under 18 years can't have expenses")
public class UnderAgeException extends RuntimeException{

    public UnderAgeException(){
        super("Persons under 18 years can't have expense Transactions");
    }

}
