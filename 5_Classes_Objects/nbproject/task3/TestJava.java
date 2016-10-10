package task3;

import java.util.Scanner;

public class TestJava {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"For how many vehicles are you typing an information?");
		int countOfPeople = scanner.nextInt();
		System.out.println(
				"Enter gas price");
		double gasPrice = scanner.nextDouble();
		Vehicle vehicle = new Vehicle();
		vehicle.vehicleMotor(vehicle, gasPrice, countOfPeople);	
	}
}

