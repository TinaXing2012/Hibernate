package xing.rujuan.manytomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Setter
@Getter
//@Entity
public class Car {

    @Id
    private Long id;
    private String model;
    private String color;

    @ManyToMany(mappedBy = "cars")
    private List<Person> people;

}
