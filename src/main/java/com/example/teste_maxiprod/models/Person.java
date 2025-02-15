package com.example.teste_maxiprod.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "Person")
@Table(name = "persons")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Integer age;
    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    @OrderBy("priority Desc")
    private List<TransactionObj> transactions;

}
