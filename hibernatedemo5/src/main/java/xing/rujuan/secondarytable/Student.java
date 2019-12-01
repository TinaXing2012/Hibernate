package xing.rujuan.secondarytable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
//@Entity
@SecondaryTable(name = "person")
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(table = "person")
    private String ssn;

    @Column(table = "person")
    private String firstName;

    @Column(table = "person")
    private String lastName;

    private String major;
    private LocalDate entry;

    public Student(String ssn, String firstName, String lastName, String major, LocalDate entry) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.entry = entry;
    }
}
