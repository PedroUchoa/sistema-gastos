package com.example.teste_maxiprod.repositories;


import com.example.teste_maxiprod.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,String> {
}
