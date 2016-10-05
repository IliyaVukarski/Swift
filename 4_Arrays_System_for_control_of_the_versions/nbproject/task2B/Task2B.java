package task2B;

import java.util.Arrays;
import java.util.Scanner;

public class Task2B {

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
		Arrays.sort(array);
		for(int element : array) {
			System.out.println(element);
		}
	}

}
