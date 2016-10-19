package Task2_UniversityManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniversityManagement {
	
	public static Person findPerson(String name, List<Person> people, int peopleCount) {
		for(int index = 0; index < peopleCount; index++) {
			if(people.get(index).getName().equalsIgnoreCase(name)) {
				return people.get(index);
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Person> people = new ArrayList<>();
		int peopleCount = 0;
		double balance = 500;
		
		while(true) {
			System.out.println("END NEW WORK IDLE");
			String[] userCommand = scanner.next().split(" ");
			if(userCommand[0].equalsIgnoreCase("END")) {
				break;
			}
			for(String com : userCommand) {
				if(com.equalsIgnoreCase("NEW")) {
					System.out.println("Enter occupation name phoneNumber");
					String occupation = scanner.next();
					String name = scanner.next();
					String  telephoneNumber = scanner.next();
					String[] subject = scanner.next().split(" ");
					List<String> subjects = new ArrayList<>();
					for(int index = 0; index < subject.length; index++) {
						subjects.add(subject[index]);
					}
					String[] arrayOfSubjects = (String[]) subjects.toArray();
					
					System.out.println("ADMIN , TEACHER, MAINTANANCE, STUDENT");
					if(occupation.equalsIgnoreCase("ADMIN")) {
						people.add(new AdministrationEmployee(name, telephoneNumber,  arrayOfSubjects));
					}else if(occupation.equalsIgnoreCase("TEACHER")) {
						people.add(new Teacher(name, telephoneNumber, arrayOfSubjects));
					}else if(occupation.equalsIgnoreCase("MAINTENANCE")) {
						people.add(new MaintenanceEmployee(name, telephoneNumber));
					}else if(occupation.equalsIgnoreCase("STUDENT")) {
						System.out.println("Enter faculty Number");
						String facultyNumber = scanner.next();
						people.add(new Student(name, telephoneNumber, facultyNumber, arrayOfSubjects));
					}
				}else if(com.equalsIgnoreCase("WORK")) {
					String name = scanner.next();
					Person person = findPerson(name, people, peopleCount);
					balance = balance + person.work(people, peopleCount);
					if(balance < 0) {
						System.out.println("Bankrupcy");
					}
					
					for(int index = 0; index < peopleCount; index++) {
						if(people.get(index).getIndividualTolerance()  <= 0) {
							System.out.println(people.get(index).getName() + " is not happy");
						}
					}
				}else if(com.equalsIgnoreCase("IDLE")) {
					for(int index = 0; index < peopleCount; index++) {
						people.get(index).decreaseTolerance(5);
						if(people.get(index).getIndividualTolerance()  <= 0) {
							System.out.println(people.get(index).getName() + " is not happy");
						}
					}
				}
			}
			System.out.println(balance);
		}
	}
}
