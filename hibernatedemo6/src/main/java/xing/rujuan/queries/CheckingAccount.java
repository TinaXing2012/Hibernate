package xing.rujuan.queries;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("checking")
public class CheckingAccount extends Account {
	private Double overdraftLimit;

	public CheckingAccount(double balance, Double overdraftLimit) {
		super(balance);
		this.overdraftLimit = overdraftLimit;
	}
}
