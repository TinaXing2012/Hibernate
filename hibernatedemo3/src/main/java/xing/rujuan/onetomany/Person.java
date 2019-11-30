package xing.rujuan.onetomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
//@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    private String firstName;
    private String lastName;

//    @OneToMany
//    @JoinTable(name = "person_addr", joinColumns = {@JoinColumn(name = "addr_id")}, inverseJoinColumns = {@JoinColumn(name="person_id")})
//    @JoinColumn(name = "p_id")

    @OneToMany(mappedBy = "person")
    private List<Address> addresses;

}
