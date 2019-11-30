package xing.rujuan.onetoone.joincolumn;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Customer {

    @Id
    public Long id;
    public String firstName;
    public String lastName;

    @OneToOne
    @JoinColumn(name = "addr_id")
    private Address address;

}
