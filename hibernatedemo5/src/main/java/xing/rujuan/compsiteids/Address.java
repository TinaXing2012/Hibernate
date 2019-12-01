package xing.rujuan.compsiteids;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String street;
    private String zipCode;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "person_firstname", referencedColumnName = "firstName"),
            @JoinColumn(name = "person_lastname", referencedColumnName = "lastName")
    })
    private Person person;

    public Address(String street, String zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }
}
