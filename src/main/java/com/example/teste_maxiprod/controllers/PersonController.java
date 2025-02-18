package com.example.teste_maxiprod.controllers;

import com.example.teste_maxiprod.dtos.UpdatePersonDto;
import com.example.teste_maxiprod.models.Person;
import com.example.teste_maxiprod.services.PersonService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    @PostMapping
    @Transactional
    public ResponseEntity<Person> addPerson(@RequestBody Person data){
        Person person =personService.createPerson(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Page<Person>> listAllPersons(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        Page<Person> persons = personService.getAllPersons(pageable);
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> listPerson(@PathVariable String id){
        Person person = personService.getPerson(id);
        return ResponseEntity.ok(person);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Person> updatePerson(@PathVariable String id, @RequestBody UpdatePersonDto updatePerson){
        Person person = personService.updatePerson(updatePerson,id);
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletePerson(@PathVariable String id){
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }


}
