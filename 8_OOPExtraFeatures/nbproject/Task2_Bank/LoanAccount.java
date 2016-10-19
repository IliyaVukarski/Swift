package Task2_Bank;

import java.util.List;

public class LoanAccount extends Account{
	
	public LoanAccount() {
		
	}
	
	public LoanAccount(String accIBAN, String accOwner, double accBalance, double monthlyInterestRate, Customer customer) {
		super(accIBAN, accOwner, accBalance, monthlyInterestRate, customer);
	}
}