package Task2_Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Account {
	private String accIBAN;
	private String accOwner;
	protected double accBalance; 
	private double monthlyInterestRate;
	private Customer customer;

	protected List<Account> accounts = new ArrayList<>();
	
	public Account() {
		
	}
	
	
	public Account(String accIBAN, String accOwner, double accBalance, double monthlyInterestRate, Customer customer) {
		this.setAccIBAN(accIBAN);
		this.setAccOwner(accOwner);
		this.setAccBalance(accBalance);
		this.setMonthlyInterestRate(monthlyInterestRate / 100);
		if(customer instanceof IndividualCustomer) {
			this.setCustomer(customer);
		}else if(customer instanceof CompanyCustomer){
			this.setCustomer(customer);
		}
	}
	
	public String getAccIBAN() {
		return accIBAN;
	}
	public void setAccIBAN(String accIBAN) {
		this.accIBAN = accIBAN;
	}
	public String getAccOwner() {
		return accOwner;
	}
	public void setAccOwner(String accOwner) {
		this.accOwner = accOwner;
	}
	public double getAccBalance() {
		return accBalance;
	}
	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	public double getMonthlyInterestRate() {
		return monthlyInterestRate;
	}
	public void setMonthlyInterestRate(double monthlyInterestRate) {
		this.monthlyInterestRate = monthlyInterestRate;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void deposit(int amount) {
		if(amount > 0) {
			accBalance = this.getAccBalance() + amount;
		}else { 
			System.out.println("I won't take this amount");
		}
	}
	
	public void put(String accName, String accIBAN, int amount) {
		for(int index = 0; index < accounts.size(); index++) {
			if(amount > 0) {
				if(accounts.get(index).getAccOwner().equalsIgnoreCase(accName) &&
				   accounts.get(index).getAccIBAN().equalsIgnoreCase(accIBAN)) {
				   accounts.get(index).deposit(amount);
				   System.out.println("The new amount is now " + accounts.get(index).getAccBalance());
				}
			}else {
				System.out.println("I won't take this amount");
			}
		}
	}
	
	public void printInfo(String accName, String accIBAN, int periodOfTime) {
		for(int index = 0; index < accounts.size(); index++) {
			if(accounts.get(index).getAccOwner().equalsIgnoreCase(accName) &&
				accounts.get(index).getAccIBAN().equalsIgnoreCase(accIBAN)) {
				System.out.println(accounts.get(index).calculateInterest(periodOfTime));	
			}
		}
	}
	
	public double calculateInterest(int periodOfTime) {
		double interest = 0;
		interest = this.getAccBalance() * this.getMonthlyInterestRate()  * periodOfTime;
		return interest;
	}
}
