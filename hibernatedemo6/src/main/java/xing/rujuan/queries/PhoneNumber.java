package xing.rujuan.queries;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Data
@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
public class PhoneNumber {
    @Id
    @GeneratedValue
    private Long id;
    private String number;
    private String type;

    public PhoneNumber(String number, String type) {
        this.number = number;
        this.type = type;
    }
}
