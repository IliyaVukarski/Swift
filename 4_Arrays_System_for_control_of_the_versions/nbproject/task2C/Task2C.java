package task2C;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task2C {

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
		int count = 0;
		for(int index = 0; index < array.length; index++) {
			int element = index + 1;
			if(array[index] == array[element]) {
				count++;
				while((array[index]==array[element])) {
					if(element == array.length - 1) {
						break;
					}

					element++;
				}
			}
			index = element - 1;
			if(index == array.length - 2) {
				break;
			}
		}
		System.out.println("cluster " +count);
	}
	
}
