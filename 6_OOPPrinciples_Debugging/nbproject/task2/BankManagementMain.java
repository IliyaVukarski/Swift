package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.InputMapUIResource;

public class BankManagementMain {

	public static void main(String[] args) {
		List<Account> bankAccounts = new ArrayList<>();
		Account account = new Account();
		Bank bank = new Bank();
		Credetials credetials = new Credetials();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("OPEN, CLOSE, DEPOSIT, WITHDRAW, TRANSFER, CheckAssets, END");
			String inpuUserCommand = scanner.next();
			if(inpuUserCommand.equalsIgnoreCase("END")) {
				break;
			}
			System.out.println("Name");
			String clientName = scanner.next();
			account.setClientName(clientName);
			System.out.println("id");
			int governmentId = scanner.nextInt();
			account.setGovId(governmentId);
			System.out.println("username");
			String username = scanner.next();
			credetials.setUserName(username);
			System.out.println("password");
			String password = scanner.next();
			credetials.setPassword(password);
			account.setCredetials(credetials);
			bank.setAccounts(bankAccounts);
			bank.setAccount(account);
			bank.setCredetials(credetials);
			if(inpuUserCommand.equalsIgnoreCase("OPEN")) {
				bank.openAccount(clientName, governmentId, username, password);
			}else if(inpuUserCommand.equalsIgnoreCase("CLOSE")) {
				bank.closeAccount(username, password);
			}else if(inpuUserCommand.equalsIgnoreCase("DEPOSIT")) {
				System.out.println("Please enter an an amount to deposit");
				int amount = scanner.nextInt();
				bank.deposit(username, amount);
			}else if(inpuUserCommand.equalsIgnoreCase("WITHDRAW")) {
				System.out.println("Please enter an an amount to deposit");
				int amount = scanner.nextInt();
				bank.withdraw(username, password, amount);
			}else if(inpuUserCommand.equalsIgnoreCase("TRANSFER")) {
				System.out.println("Please enter an an amount to transfer");
				int amount = scanner.nextInt();
				Account receiptient = new Account();
				Credetials cr = new Credetials();
				System.out.println("Name");
				String transferName = scanner.next();
				receiptient.setClientName(transferName);
				System.out.println("id");
				int transferId = scanner.nextInt();
				receiptient.setGovId(transferId);
				System.out.println("username");
		     	String transferNamme = scanner.next();
				cr.setUserName(transferNamme);
				System.out.println("password");
				String tranferPass = scanner.next();
				cr.setPassword(tranferPass);
			}else if(inpuUserCommand.equalsIgnoreCase("CheckAssets")){
				bank.calculateAccountAssets();
			}else {
				System.out.println("Unknown command");
			}
		}
	}
}
