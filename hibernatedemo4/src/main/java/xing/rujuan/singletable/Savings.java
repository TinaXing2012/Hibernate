package xing.rujuan.singletable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
//@Entity
@DiscriminatorValue(value = "2")
public class Savings extends Account {

    private double interest;

    public Savings(double balance, double interest) {
        super(balance);
        this.interest = interest;
    }
}
