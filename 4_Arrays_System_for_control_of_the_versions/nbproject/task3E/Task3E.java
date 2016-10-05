package task3E;

import java.util.Scanner;

public class Task3E {
	
	public static void main(String[] args) {
		System.out.println("Enter two strings");
		Scanner scanner = new Scanner(System.in);
		System.out.print("First string");
		String firstString = scanner.nextLine();
		System.out.print("Second string");
		String secondString = scanner.nextLine();
		System.out.println("Search1 = " + firstString.contains(secondString));
	
	}
}
