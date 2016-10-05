package task1B;

import java.util.Scanner;

public class Task1B {

	public static void main(String[] args) {
		System.out.println("Enter number for rows and columns");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		int count = 0;
		int[][] matrix = new int[number][number];
		
		for(int columns = 0; columns < matrix.length;columns++ ) {
			for(int rows = 0; rows < matrix[columns].length; rows++) {
				matrix[rows][columns] = count;
				count++;
			}
			System.out.println();
		};
		
		for(int rows = 0; rows < matrix.length; rows++) {
			
			for(int columns = 0; columns < matrix[rows].length; columns++) {
				System.out.print(matrix[rows][columns] + " ");
			}
			System.out.println();
		};
	}

}
