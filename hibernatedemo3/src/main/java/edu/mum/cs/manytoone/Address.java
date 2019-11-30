package edu.mum.cs.manytoone;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@Getter
@Entity
public class Address {

    @Id
    private Long id;
    private String street;
    private String zipCode;

    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;

}
