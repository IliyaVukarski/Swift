package Task2_Bank;

import java.math.BigDecimal;
import Task1_Credentials.Credentials;

public class Account {
	private String clientName;
	private long getGovernmentId;
	private double accountBalance;
	private Credetials credetials;
	
	public Account() {
		 
	}
	
	public Account(String clientName, long getGovernmentId, 
				   double accountBalance, String userName, 
				   String password, Credetials credetials) {
		this.setClientName(clientName);
		this.setGovId(getGovernmentId);
		this.setAccountBalance(accountBalance);
		this.setCredetials(credetials);
		this.credetials.setUserName(userName);
		this.credetials.setPassword(password);
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Credetials getCredetials() {
		return credetials;
	}

	public void setCredetials(Credetials credetials) {
		this.credetials = credetials;
	}
	
	public String getClientName() {
		return clientName;
	}
	
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	public long getGovernmentId() {
		return getGovernmentId;
	}
	
	public void setGovId(long getGovernmentId) {
		this.getGovernmentId = getGovernmentId;
	}
	
	public void deposit(int amount) {
		if(amount > 0) {
			accountBalance = this.getAccountBalance() + amount;
		}else {
			System.out.println("I won't take this amount");
		}
	}
	
	public void withdraw(int amount) {
		if(amount > 0 && this.getAccountBalance() >= amount) {
			accountBalance = this.getAccountBalance() - amount;
		}else {
			System.out.println("You don't have enough money in your account");
		}
	}
	
	public boolean hasAccess(String password) {
		if(this.getCredetials().getPassword().equalsIgnoreCase(password)) {
			return true;
		}else {
			return false;
		}
	}
	
	public double getBalance() {
		return this.getAccountBalance();
	}
	
	public long getGovId() {
		return this.getGovId();
	}
	
	public String getName() {
		return this.getCredetials().getUserName();
	}
}

