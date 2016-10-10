package task4;

import java.beans.PersistenceDelegate;
import java.util.Scanner;

public class Calculator {
	
	public static void sumElements(String operation, double numA, double numB) {
		System.out.println(operation +" "+ numA +" "+ numB);
		System.out.println(numA + numB);
	}
	
	public static void subtractElements(String operation, double numA, double numB) {
		System.out.println(operation +" "+ numA +" "+ numB);
		System.out.println(numA - numB);
	}
	
	public static void multiplyElements(String operation, double numA, double numB) {
		System.out.println(operation +" "+ numA +" "+ numB);
		System.out.println(numA * numB);
	}
	
	public static void divideElements(String operation, double numA, double numB) {
		System.out.println(operation +" "+ numA +" "+ numB);
		System.out.println(numA / numB);
	}
	
	public static void percentage(String operation, double numA, double numB) {
		System.out.println(operation +" "+ numA +" "+ numB);
		System.out.println(Math.pow(numA, numB));
	}
	
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
				sumElements(operation, numberA, numberB);
				break;
			case "SUB": 
				subtractElements(operation, numberA, numberB);
				break;
			case "MUL": 
				multiplyElements(operation, numberA, numberB);
				break;
			case "DIV": 
				divideElements(operation, numberA, numberB);
				break;
			case "PER": 
				percentage(operation, numberA, numberB);
				break;
			}
		}
	}
}
