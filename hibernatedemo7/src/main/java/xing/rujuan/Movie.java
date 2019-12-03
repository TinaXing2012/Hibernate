package xing.rujuan;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Movie(String name) {

        this.name = name;
    }

}
