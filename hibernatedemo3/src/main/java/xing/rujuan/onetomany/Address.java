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

}
