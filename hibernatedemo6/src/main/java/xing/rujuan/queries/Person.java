package xing.rujuan.queries;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@ToString(exclude = {"address"})
@NoArgsConstructor
@Entity
@NamedQueries({
   @NamedQuery(name="Person.everyone", query = "from Person")
})
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
//    private String id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address address;

}
