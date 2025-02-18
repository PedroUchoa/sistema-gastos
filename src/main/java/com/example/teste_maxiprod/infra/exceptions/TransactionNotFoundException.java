package com.example.teste_maxiprod.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Transaction Not Found in the DataBase")
public class TransactionNotFoundException extends RuntimeException{

    public TransactionNotFoundException(String id){
        super("Transaction with id: " + id + " Not Found");
    }

}
