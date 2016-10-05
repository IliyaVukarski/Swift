package task4;

import java.util.Scanner;

public class Calculator {

	public static void operations() {
		
		while(true) {
			System.out.println("Please Choose TypeOfOperation");
			System.out.println("between SUM, SUB, MUL, DIV, PER or END");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			if(input.equalsIgnoreCase("END")) {
				break;
			}
			String operation = input;
			System.out.print("Enter first number");
			double numberA = 0;
			numberA = scanner.nextDouble();
			System.out.print("Enter second number");
			double numberB = 0;
			numberB = scanner.nextDouble();
			
			switch(operation) {
			case "SUM":
				System.out.println(operation +  numberA +" "+ numberB);
				System.out.println(numberA + numberB);
				break;
			case "SUB": 
				System.out.println(operation +  numberA +" "+ numberB);
				System.out.println(numberA - numberB);
				break;
			case "MUL": 
				System.out.println(operation +  numberA +" "+ numberB);
				System.out.println(numberA * numberB);
				break;
			case "DIV": 
				System.out.println(operation +  numberA +" "+ numberB);
				System.out.println(numberA / numberB);
				break;
			case "PER": 
				System.out.println(operation +  numberA +" "+ numberB);
				System.out.println(Math.pow(numberA, numberB));
				break;
			}
		}
	}
}
