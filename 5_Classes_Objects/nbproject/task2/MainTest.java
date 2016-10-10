package task2;

import java.util.Scanner;

public class MainTest {
public static void main(String[] args) {
		System.out.println(
				"For how many people are you typing an information?");
		Scanner scanner = new Scanner(System.in);
		Employee employee = new Employee();
		employee.employeeSalarySort(employee, scanner.nextInt());
	}
}
