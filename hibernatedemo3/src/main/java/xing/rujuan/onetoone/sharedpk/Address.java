package xing.rujuan.onetoone.sharedpk;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Address {

    @Id
    private Long id;
    private String street;
    private String zipCode;
}
