package com.example.teste_maxiprod.repositories;


import com.example.teste_maxiprod.models.TransactionObj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionObj,String> {
}
