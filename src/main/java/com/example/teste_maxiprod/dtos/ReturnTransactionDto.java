package com.example.teste_maxiprod.dtos;

import com.example.teste_maxiprod.models.TransactionObj;
import com.example.teste_maxiprod.models.TransactionType;

public record ReturnTransactionDto(String id, String Description, Integer value, TransactionType type, String personName) {

    public ReturnTransactionDto(TransactionObj transactionObj){
        this(transactionObj.getId(), transactionObj.getDescription(), transactionObj.getValue(), transactionObj.getType(),transactionObj.getPerson().getName());
    }

}
