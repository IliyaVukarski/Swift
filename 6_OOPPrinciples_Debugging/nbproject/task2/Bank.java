package task2;

import java.util.List;

public class Bank  {
	private List<Account> accounts;
	private Account account;
	private Credetials credetials;
	
	public Bank() {
		
	}

	public Bank(List<Account> accounts, Account account, Credetials credetials) {
		this.setAccounts(accounts);
		this.setAccount(account);
		this.setCredetials(credetials);
	}
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Credetials getCredetials() {
		return credetials;
	}

	public void setCredetials(Credetials credetials) {
		this.credetials = credetials;
	}
	
	public void openAccount(String clientName, long governmentId, String username, String password) {
		clientName = account.getClientName();
		governmentId = account.getGovernmentId();
		username = credetials.getUserName(); 
		password = credetials.getPassword();
		double accountBalance = account.getAccountBalance();
		System.out.printf("Openning new account for %s %d", clientName, governmentId);
		System.out.println();
		accounts.add(new Account(clientName, governmentId, accountBalance, username, password, credetials));
		for(Account acc : accounts) {
			System.out.println(acc.getClientName() + " " +
					           acc.getGovernmentId() + " " + 
					           acc.getAccountBalance() + " " +
					           acc.getCredetials().getUserName() + " " +
					           acc.getCredetials().getPassword());
		}
	}
	
	public void closeAccount(String username, String password) {
		for(int index = 0; index < accounts.size(); index++) {
			if(accounts.get(index).getCredetials().getUserName().equalsIgnoreCase(username) &&
			   accounts.get(index).getCredetials().getPassword().equalsIgnoreCase(password)) {
			   accounts.remove(index);
			   System.out.printf("Closing and deleting account with number %d", 
					   			 accounts.get(index).getGovernmentId());
			   System.out.println();
			}
		}
	}
	
	public void deposit(String username, int amount) {
		for(int index = 0; index < accounts.size(); index++) {
			if(amount > 0) {
				if(accounts.get(index).getCredetials().getUserName().equalsIgnoreCase(username)) {
				    accounts.get(index).setAccountBalance(accounts.get(index).getAccountBalance() + amount); 
				    System.out.println("The new amount is now" + accounts.get(index).getAccountBalance());
				}
			}else {
				System.out.println("Invalid amount!");
			}
		}
	}
	
	public void withdraw(String username, String password, int amount) {
		for(int index = 0; index < accounts.size(); index++) {
			if(amount >0 && accounts.get(index).getAccountBalance() > 0) {
				if(accounts.get(index).getCredetials().getUserName().equalsIgnoreCase(username) &&
				   accounts.get(index).getCredetials().getPassword().equalsIgnoreCase(password)) {
				   accounts.get(index).setAccountBalance(accounts.get(index).getAccountBalance() - amount); 
				}
			}else {
				System.out.println("You don't have enough money in your account");
			}
			
		}
	}

	public void transfer(String username, int amount, Account receipient) {
		for(int index = 0; index < accounts.size(); index++) {
			if(amount > 0 && accounts.get(index).getAccountBalance() > 0) {
				if(accounts.get(index).getCredetials().getUserName().equalsIgnoreCase(username)) {
				   accounts.get(index).setAccountBalance(accounts.get(index).getAccountBalance() - amount);
				   System.out.println("The balance now is" + accounts.get(index).getAccountBalance());
				}
				if(accounts.get(index).getCredetials().getUserName().equalsIgnoreCase(receipient.getCredetials().getUserName())) {
				   accounts.get(index).setAccountBalance(accounts.get(index).getAccountBalance() + amount);
				   System.out.println("The balance now is" + accounts.get(index).getAccountBalance());
				}
			}else {
				System.out.println("Invalid amount!");
			}
		}
	}
	
	public double calculateAccountAssets() {
		double accountAssets = 0;
		for(Account account : accounts) {
			accountAssets = accountAssets + account.getAccountBalance();
		}
		System.out.println("The current balance of the accounts Assets is" + accountAssets);
		return accountAssets;
	}
}
