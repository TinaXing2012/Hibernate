package xing.rujuan.onetoone.sharedpk;

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


    @OneToOne
    @PrimaryKeyJoinColumn
    private Customer customer;

}
