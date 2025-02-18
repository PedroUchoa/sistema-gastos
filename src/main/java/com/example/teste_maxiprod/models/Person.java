package com.example.teste_maxiprod.models;

import com.example.teste_maxiprod.dtos.TotalTransactionDto;
import com.example.teste_maxiprod.dtos.UpdatePersonDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "persons")
@Entity(name = "Person")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Integer age;
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonManagedReference
    private List<TransactionObj> transactions = new ArrayList<>();

    public Person() {
    }

    public Person(String id, List<TransactionObj> transactions, Integer age, String name) {
        this.id = id;
        this.transactions = transactions;
        this.age = age;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<TransactionObj> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionObj> transactions) {
        this.transactions = transactions;
    }

    public void update(UpdatePersonDto newPerson) {
        if(newPerson.name() != null && !newPerson.name().isBlank()){
            this.name = newPerson.name();
        }
        if(newPerson.age() != null ){
            this.age = newPerson.age();
        }
    }

    public TotalTransactionDto totalTransaction(){
        int totalIncome = 0;
        int totalExpense = 0;
        for (TransactionObj data : this.getTransactions()){
            if(data.getType() == TransactionType.INCOME) totalIncome += data.getValue();
            if(data.getType() == TransactionType.EXPENSE) totalExpense += data.getValue();
     }

        return new TotalTransactionDto(this.name,totalIncome,totalExpense,totalIncome-totalExpense);
    }

}
