package Task1_PeoplePresentation;

import java.util.Scanner;

public class UniversityInfoMain {
	public static void main(String[] args) {
		Person person = null;
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("END Student Worker");
			String[] command = scanner.next().split(" ");
			if(command[0].equalsIgnoreCase("END")) {
				break;
			}
			for(String com : command) {
				
				if(com.equalsIgnoreCase("Worker")) {
					System.out.println("Enter firstName lastname WeekSalary WorkHoursPerPay");
					String firstName = scanner.next();
					String lastName = scanner.next();
					double weekSalary = scanner.nextDouble();
					int workHoursPerDay = scanner.nextInt();
						person = new Worker(firstName, lastName, weekSalary, workHoursPerDay);
					if(person instanceof Worker) {
						System.out.println("Salary per hour: " + ((Worker) person).calculateSalary());
					}
				}else if(com.equalsIgnoreCase("Student")) {
					System.out.println("Enter firstName lastname lectureCount exerciseCount");
					String firstName = scanner.next();
					String lastName = scanner.next();
					int lectureCount = scanner.nextInt();
					int exerciseCount = scanner.nextInt();
					person = new Student(firstName, lastName, lectureCount, exerciseCount);
					if(person instanceof Student) {
						System.out.println("Hours per day: " + ((Student) person).calculateHoursPerWeek());
					}
				}else {
					System.out.println("Wrong input");
				}
			}
		}
	}
}
