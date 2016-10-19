package Task2_Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BankMain {

	public static void main(String[] args) {
		List<Account> bankAccounts = new ArrayList<>();
		List<String> userCommands = new ArrayList<>();
		userCommands.add("OPEN");
		userCommands.add("PUT");
		userCommands.add("GET");
		userCommands.add("INFO");
		userCommands.add("END");
		Customer typeCustomer = null;
		Account acc = null;
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("OPEN, PUT, GET, INFO, END");
			String[] command = scanner.next().split(" ");
			if(command[0].equalsIgnoreCase(userCommands.get(4))) {
				break;
			}
			for(String com : command) {
				if(com.equalsIgnoreCase(userCommands.get(0))) {
					
					System.out.println("type of account  1 for deposit 2 for loan or 3 for mortgade");
					int inputAccount = scanner.nextInt();
					if(inputAccount == 1) {
						acc = new DepositAccount();
					}else if (inputAccount == 2) {
						acc = new LoanAccount();
					}else if (inputAccount == 3) {
						acc = new MortgageAccount();
					}
					
					if(acc instanceof DepositAccount) {
						bankAccounts.add(acc);
					}else if (acc instanceof  LoanAccount) {
						bankAccounts.add(acc);
					}else if (acc instanceof MortgageAccount) {
						bankAccounts.add(acc);
					}
					
					System.out.println("type of customer  1 - for individual 2 for company");
					int inputCustomer = scanner.nextInt();
					if(inputCustomer == 1) {
						typeCustomer = new IndividualCustomer();
					}else if(inputCustomer == 2) {
						typeCustomer = new CompanyCustomer();
					}

					System.out.println("Enter Owner balance MonthlyInterestRate");
					acc.setAccOwner(scanner.next());
					acc.setAccBalance(scanner.nextDouble());
					acc.setMonthlyInterestRate(scanner.nextInt());
					acc.setCustomer(typeCustomer); 
					Random random = new Random();
					int iban = random.nextInt(1000000000);
					String accIBAN = String.valueOf(iban);
					acc.setAccIBAN(accIBAN);
					
					
				}else if(com.equalsIgnoreCase(userCommands.get(1))) {
					System.out.println("Enter Owner name");
					String owner = scanner.next();
					System.out.println("Enter amount to be deposit in your account");
					int amount = scanner.nextInt();
					for(int index = 0; index < bankAccounts.size(); index++) {
						if(bankAccounts.get(index).getAccOwner().equalsIgnoreCase(owner)){
							bankAccounts.get(index).deposit(amount);
						}
					}
					
				}else if(com.equalsIgnoreCase(userCommands.get(2))) {
					System.out.println("Enter Owner name");
					String owner = scanner.next();
					System.out.println("Enter amount to be withdrawed from your account");
					int amount = scanner.nextInt();
					for(int index = 0; index < bankAccounts.size(); index++) {
						if(bankAccounts.get(index).getAccOwner().equalsIgnoreCase(owner)){
							if(bankAccounts.get(index) instanceof DepositAccount) {
								((DepositAccount) bankAccounts.get(index)).withdraw(amount);
							}else {
								System.out.println("You are not allowed to withdraw");
							}
						}
					}
					
				}else if(com.equalsIgnoreCase(userCommands.get(3))) {
					System.out.println("Enter Owner balance MonthlyInterestRate");
					for(Account account : bankAccounts){
						 System.out.println(
								 account.getAccIBAN() + " " +
								 account.getAccOwner() + " " +
								 account.getMonthlyInterestRate() + " " +
								 account.getAccBalance()
						 );
					}
					System.out.println("Enter period of time ");
					int periodOfTime = scanner.nextInt();
					for(Account account : bankAccounts){
						acc.printInfo(account.getAccOwner(), 
							      account.getAccIBAN(), 
							      periodOfTime);
						acc.calculateInterest(periodOfTime);
						System.out.println(account.getAccOwner() + " " + 
							      account.getAccIBAN() + " " +
							      account.getAccBalance() + " " +
							      periodOfTime);
					}
					
				}else {
					System.out.println("Invalid input");
				}	
			}
		}
	}
}
