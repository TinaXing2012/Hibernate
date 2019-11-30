package xing.rujuan.onetoone.embeddable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
//@Entity
public class Customer {

    @Id
    @GeneratedValue
    public Long id;
    public String firstName;
    public String lastName;

    @Embedded
    private Address address;

}
