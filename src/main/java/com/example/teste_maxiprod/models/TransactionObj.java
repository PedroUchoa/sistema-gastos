package com.example.teste_maxiprod.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity(name = "TransactionObj")
@Table(name = "transactions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TransactionObj {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String description;
    private Integer value;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinTable(name = "person_transactions",
            joinColumns = {@JoinColumn (name = "transaction_id")},
            inverseJoinColumns = {@JoinColumn(name = "person_id")})
    @JsonBackReference
    private Person person;

    public TransactionObj() {
    }

    public TransactionObj(String id, Person person, Integer value, String description, TransactionType type) {
        this.id = id;
        this.person = person;
        this.value = value;
        this.description = description;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
