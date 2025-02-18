package com.example.teste_maxiprod.services;


import com.example.teste_maxiprod.dtos.CreateTransactionDTO;
import com.example.teste_maxiprod.dtos.TotalTransactionDto;
import com.example.teste_maxiprod.infra.exceptions.PersonNotFoundException;
import com.example.teste_maxiprod.infra.exceptions.TransactionNotFoundException;
import com.example.teste_maxiprod.infra.exceptions.UnderAgeException;
import com.example.teste_maxiprod.models.Person;
import com.example.teste_maxiprod.models.TransactionObj;
import com.example.teste_maxiprod.models.TransactionType;
import com.example.teste_maxiprod.repositories.PersonRepository;
import com.example.teste_maxiprod.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;


    @Autowired
    private PersonRepository personRepository;

    public TransactionObj createTransaction(CreateTransactionDTO data){
        Person person = personRepository.findById(data.idPerson()).orElseThrow(()->new PersonNotFoundException(data.idPerson()));
        if(person.getAge() < 18 && data.type() == TransactionType.EXPENSE) throw new UnderAgeException();
        TransactionObj transactionObj = new TransactionObj(data,person);
        person.getTransactions().add(transactionObj);
        personRepository.save(person);
        return transactionRepository.save(transactionObj);
    }

    public TransactionObj getTransaction(String id){
        return transactionRepository.findById(id).orElseThrow(()-> new TransactionNotFoundException(id));
    }

    public Page<TransactionObj> getAllTransactions(Pageable pageable){
        return transactionRepository.findAll(pageable);
    }

    public List<TotalTransactionDto> getAllTransactions(){
        List<TotalTransactionDto> totalTransactions = new ArrayList<>();
        List<Person> persons  = personRepository.findAll();
        for(Person data : persons){
            totalTransactions.add(data.totalTransaction());
        }
        return totalTransactions;
    }


}
