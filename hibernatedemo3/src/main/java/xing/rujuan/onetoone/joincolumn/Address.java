package xing.rujuan.onetoone.joincolumn;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Address {

    @Id
//    @Column(name = "address_id")
    private Long id;
    private String street;
    private String zipCode;

}
