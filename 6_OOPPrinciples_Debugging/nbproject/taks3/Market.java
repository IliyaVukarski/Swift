package taks3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Market {
	
	public void buyFromTheStore(Person per, Product pr) {
		if(per.getPersonBalance() > pr.getProductPrice()) {
			System.out.println("You bought it!" + pr.getProductName());
		}else if(per.getPersonBalance() <= 0){
			System.out.println("Your balance is negative!");
		}else {
			System.out.println("Not enough money!");
		}
	}
	
	public static void main(String[] args) {
		Person person = new Person();
		Product product = new Product();
		Market market = new Market();
		String input = null;
		do {
			System.out.println("Type END to exit or press any key to continue");
			Scanner scanner = new Scanner(System.in);
			input = scanner.next();
			if(input.equalsIgnoreCase("END")) {
				break;
			}
			System.out.println("Enter person name");
			String personName = scanner.next();
			person.setPersonName(personName); 
			System.out.println("Enter person balance");
			double personBalance = scanner.nextDouble();
			person.setPersonBalance(personBalance);
			
			System.out.println("Enter product name");
			String productName = scanner.next();
			product.setProductName(productName);
			System.out.println("Enter product balance");
			double productBalance = scanner.nextDouble();
			product.setProductPrice(productBalance);
			market.buyFromTheStore(person, product);
		}while(input.equalsIgnoreCase("END"));
		
	}
}
