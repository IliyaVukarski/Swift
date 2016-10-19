package Task2_Bank;

import java.util.List;

public class MortgageAccount extends Account {
	
	public MortgageAccount() {
		
	}
	
	public MortgageAccount(String accIBAN, String accOwner, double accBalance, double monthlyInterestRate,  Customer customer) {
		super(accIBAN, accOwner, accBalance, monthlyInterestRate, customer);
	}
}
