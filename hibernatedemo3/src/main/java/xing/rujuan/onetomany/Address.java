package xing.rujuan.onetomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Address {

    @Id
    private Long id;
    private String street;
    private String zipCode;

    @ManyToOne
    @JoinTable(name = "person_address", joinColumns = {@JoinColumn(name = "address_id")}, inverseJoinColumns = {@JoinColumn(name = "person_id")})
    private Person person;

}
