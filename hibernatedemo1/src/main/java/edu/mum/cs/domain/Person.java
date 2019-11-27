package edu.mum.cs.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "mycustomizedperson")
@Entity(name="people")
public class Person {

    @Id
    private Long id;
    private String firstName;
    private String lastName;

    public Person(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
