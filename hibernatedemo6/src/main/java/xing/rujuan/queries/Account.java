package xing.rujuan.queries;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@ToString
@NoArgsConstructor
@Setter
@Getter
@Entity
public abstract class Account {
	@Id
	@GeneratedValue
	private Long number;
	private double balance;

	public Account(double balance) {
		this.balance = balance;
	}
}
