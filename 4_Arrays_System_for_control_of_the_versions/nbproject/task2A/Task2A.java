package task2A;

import java.util.Scanner;

public class Task2A {

	public static void main(String[] args) {
		System.out.println("Enter one number to describe the length of array");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		int[] array = new int[number];
		for(int index = 0; index < number; index++) {
			System.out.println("Entering number at index " + index);
			int currentNumber = scanner.nextInt();
			array[index] = currentNumber;
		}
		int temporary = 0;
		for(int index = 0; index < array.length; index++) {
			temporary = array[0];
			if(array[0] < array[index]) {
				temporary = array[index];
			}
		}
		System.out.println(temporary);
	}
}
