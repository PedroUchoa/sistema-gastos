package com.example.teste_maxiprod.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "TransactionObj")
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

}
