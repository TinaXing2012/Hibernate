package xing.rujuan.tableperconcreteclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Savings extends Account {

    private double interest;

    public Savings(double balance, double interest) {
        super(balance);
        this.interest = interest;
    }
}
