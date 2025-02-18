package com.example.teste_maxiprod.dtos;

import com.example.teste_maxiprod.models.TransactionType;

public record CreateTransactionDTO(String description, Integer value, TransactionType type, String idPerson){}
