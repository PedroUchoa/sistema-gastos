package com.example.teste_maxiprod.services;


import com.example.teste_maxiprod.models.Person;
import com.example.teste_maxiprod.models.TransactionObj;
import com.example.teste_maxiprod.repositories.PersonRepository;
import com.example.teste_maxiprod.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;


    @Autowired
    private PersonRepository personRepository;

    public TransactionObj createTransaction(TransactionObj transactionObj){
        Person person = personRepository.getReferenceById(transactionObj.getId());
        person.getTransactions().add(transactionObj);
        personRepository.save(person);
        return transactionRepository.save(transactionObj);
    }

    public TransactionObj getTransaction(String id){
        return transactionRepository.getReferenceById(id);
    }

    public List<TransactionObj> getAllTransactions(){
        return transactionRepository.findAll();
    }



}
