package com.example.teste_maxiprod.services;

import com.example.teste_maxiprod.dtos.UpdatePersonDto;
import com.example.teste_maxiprod.infra.exceptions.PersonNotFoundException;
import com.example.teste_maxiprod.models.Person;
import com.example.teste_maxiprod.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person person){
        return personRepository.save(person);
    }

    public Person getPerson(String id){
        return personRepository.findById(id).orElseThrow(()-> new PersonNotFoundException(id));
    }

    public Page<Person> getAllPersons(Pageable pageable){
        return personRepository.findAll(pageable);
    }

    //Utilizando um Dto Para a atualização da Pessoa pois assim tenho certeza que o campo "id" não podera ser alterado
    public Person updatePerson(UpdatePersonDto updatePerson, String id){
        Person person = personRepository.findById(id).orElseThrow(()-> new PersonNotFoundException(id));;
        person.update(updatePerson);
        return personRepository.save(person);
    }

    //Eu normalmente não gosto de fazer com que o dado seja excluido permanentemente do banco, gosto de manter ele apenas desativado, mas para manter a api simples dessa vez vou fazer a exclusão total do dado.
    public void deletePerson(String id){
        Person person = personRepository.findById(id).orElseThrow(()-> new PersonNotFoundException(id));;
        personRepository.delete(person);
    }


}
