package xing.rujuan.onetoone.joincolumn;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Address {

    @Id
//    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String zipCode;

    @OneToOne
    private Customer customer;

    public Address(String street, String zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }
}
