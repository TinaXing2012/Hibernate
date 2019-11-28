package edu.mum.cs.domain;

import javax.persistence.*;

@Table(name = "mycustomizedperson")
@Entity(name="people")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private Long id;

    @Column(name = "first", length = 50)
    private String firstName;
    private String lastName;

    @Column(unique = true, length = 250)
    private String email;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
