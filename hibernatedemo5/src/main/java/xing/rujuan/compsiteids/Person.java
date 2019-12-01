package xing.rujuan.compsiteids;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Person {

    @EmbeddedId
    private Name name;

    private LocalDate birthDate;

    public Person(Name name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }
}
