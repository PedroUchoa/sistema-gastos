package com.example.teste_maxiprod.controllers;

import com.example.teste_maxiprod.dtos.CreateTransactionDTO;
import com.example.teste_maxiprod.dtos.ReturnTransactionDto;
import com.example.teste_maxiprod.dtos.TotalTransactionDto;
import com.example.teste_maxiprod.models.Person;
import com.example.teste_maxiprod.models.TransactionObj;
import com.example.teste_maxiprod.services.TransactionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @PostMapping
    @Transactional
    public ResponseEntity<TransactionObj> addPerson(@RequestBody CreateTransactionDTO data){
        TransactionObj TransactionObj =transactionService.createTransaction(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(TransactionObj);
    }

    @GetMapping
    public ResponseEntity<Page<ReturnTransactionDto>> listAllPersons(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        Page<ReturnTransactionDto> TransactionObj = transactionService.getAllTransactions(pageable);
        return ResponseEntity.ok(TransactionObj);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReturnTransactionDto> listPerson(@PathVariable String id){
        ReturnTransactionDto TransactionObj = transactionService.getTransaction(id);
        return ResponseEntity.ok(TransactionObj);
    }

    @GetMapping("/total")
    public ResponseEntity<List<TotalTransactionDto>> listAllTransactions(){
        List<TotalTransactionDto> totalTransactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(totalTransactions);
    }

}
