package com.example.teste_maxiprod.dtos;

public record TotalTransactionDto(String name, Integer totalIncome, Integer totalExpense, Integer total) {

    public TotalTransactionDto(String name, Integer totalIncome, Integer totalExpense, Integer total) {
        this.name = name;
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.total = total;
    }
}
