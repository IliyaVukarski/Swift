package Task2_Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.InputMapUIResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.InputMapUIResource;

public class BankManagementMain {

	public static void main(String[] args) {
		List<Account> bankAccounts = new ArrayList<>();
			
		while(true) {
			Account account = new Account();
			Bank bank = new Bank();
			Credetials credetials = new Credetials();
			Scanner scanner = new Scanner(System.in);
			System.out.println("OPEN, CLOSE, DEPOSIT, WITHDRAW, TRANSFER, CheckAssets, END");
			String inpuUserCommand = scanner.next();
			if(inpuUserCommand.equalsIgnoreCase("END")) {
				break;
			}
			System.out.println("Name, id, username, password ");
			
			account.setClientName(scanner.next());

			account.setGovId(scanner.nextInt());
			
			credetials.setUserName(scanner.next());
			
			credetials.setPassword(scanner.next());
			account.setCredetials(credetials);
			bank.setAccounts(bankAccounts);
			bank.setAccount(account);
			bank.setCredetials(credetials);
			if(inpuUserCommand.equalsIgnoreCase("OPEN")) {
				bank.openAccount(account.getClientName(), 
								 account.getGovernmentId(), 
								 account.getCredetials().getUserName(),
								 account.getCredetials().getPassword());
			}else if(inpuUserCommand.equalsIgnoreCase("CLOSE")) {
				bank.closeAccount(account.getCredetials().getUserName(), 
								  account.getCredetials().getPassword());
			}else if(inpuUserCommand.equalsIgnoreCase("DEPOSIT")) {
				System.out.println("Please enter an an amount to deposit");
				int amount = scanner.nextInt();
				bank.deposit(account.getCredetials().getUserName(), amount);
			}else if(inpuUserCommand.equalsIgnoreCase("WITHDRAW")) {
				System.out.println("Please enter an an amount to withdraw");
				int amount = scanner.nextInt();
				bank.withdraw(account.getCredetials().getUserName(), 
							  account.getCredetials().getPassword(), 
							  amount);
			}else if(inpuUserCommand.equalsIgnoreCase("TRANSFER")) {
				System.out.println("Enter amount to transfer");
				int amount = scanner.nextInt();
				System.out.println("Name of recipient");
				String receipent = scanner.next();
				String acc = null;
				for (int index = 0; index < bankAccounts.size(); index++) {
				if(bankAccounts.get(index).getCredetials().getUserName().equalsIgnoreCase(receipent)) {
						acc = bankAccounts.get(index).getCredetials().getUserName();
					}
				}
				bank.transfer(account.getCredetials().getUserName(), account.getCredetials().getPassword(), amount, acc);

			}else if(inpuUserCommand.equalsIgnoreCase("CheckAssets")){
				bank.calculateAccountAssets();
			}else {
				System.out.println("Unknown command");
			}
		}
	}
}
