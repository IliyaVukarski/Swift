package Task2_Bank;

import java.util.List;

public class DepositAccount extends Account {
	
	public DepositAccount() {
		
	}
	
	public DepositAccount(String accIBAN, String accOwner, double accBalance, double monthlyInterestRate, Customer customer) {
		super(accIBAN, accOwner, accBalance, monthlyInterestRate, customer);
	}
	
	public void withdraw(int amount) {
		if(amount > 0 && this.getAccBalance() >= amount) {
			accBalance = this.getAccBalance() - amount;
		}else {
			System.out.println("You don't have enough money in your account");
		}
	}
}
