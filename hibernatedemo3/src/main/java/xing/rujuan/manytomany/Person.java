package xing.rujuan.manytomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
//@Entity
public class Person {

    @Id
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(name = "person_car", joinColumns = {@JoinColumn(name = "p_id")},
            inverseJoinColumns = {@JoinColumn(name = "c_id")})
    private List<Car> cars;

}
