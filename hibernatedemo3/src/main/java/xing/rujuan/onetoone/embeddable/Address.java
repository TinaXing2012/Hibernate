package xing.rujuan.onetoone.embeddable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Embeddable
public class Address {

  //no primary key generated in this embeddable entity
    private String street;
    private String zipCode;

}
