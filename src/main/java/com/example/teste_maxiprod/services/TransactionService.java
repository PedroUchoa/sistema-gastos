package com.example.teste_maxiprod.services;


import com.example.teste_maxiprod.dtos.CreateTransactionDTO;
import com.example.teste_maxiprod.dtos.ReturnTransactionDto;
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

    //Utilização de um DTO onde vem junto o id da pessao que essa transação vai ser colocada.
    public TransactionObj createTransaction(CreateTransactionDTO data){
        Person person = personRepository.findById(data.idPerson()).orElseThrow(()->new PersonNotFoundException(data.idPerson()));
        //Teste para saber se pode adicionar uma Transação do tipo expense, se não dispara uma exception personalizada.
        if(person.getAge() < 18 && data.type() == TransactionType.EXPENSE) throw new UnderAgeException();
        TransactionObj transactionObj = new TransactionObj(data,person);

        //Vinculando a transação com a pessoa, não é necessario salvar no banco pois o spring já faz isso.
        person.getTransactions().add(transactionObj);

        return transactionRepository.save(transactionObj);
    }

    public ReturnTransactionDto getTransaction(String id){
        TransactionObj transactionObj = transactionRepository.findById(id).orElseThrow(()-> new TransactionNotFoundException(id));
        return new ReturnTransactionDto(transactionObj.getId(),transactionObj.getDescription(),transactionObj.getValue(),transactionObj.getType(),transactionObj.getPerson().getName());
    }

    public Page<ReturnTransactionDto> getAllTransactions(Pageable pageable){
        return transactionRepository.findAll(pageable).map(ReturnTransactionDto::new);
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
