package xing.rujuan.compsiteids;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Person {

    @EmbeddedId
    private Name name;

    private LocalDate birthDate;

    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    private List<Address> addresses = new ArrayList<>();


    public Person(Name name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public void addAddress(Address address){
        addresses.add(address);
        address.setPerson(this);
    }

}
