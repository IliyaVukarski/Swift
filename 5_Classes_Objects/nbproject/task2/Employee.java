package task2;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Employee {
	
	private String name;
	private double salary;
	private String position;
	private String department;
	private int age;
	private String email;
	
	public Employee() {
		
	}

	public Employee(String name, double salary, String position, String department, int age, String email) {
		this.setName(name);
		this.setSalary(salary);
		this.setPosition(position);
		this.setDepartment(department);
		this.setAge(age);
		this.setEmail(email);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void employeeSalarySort(Employee employee, int numberOfStaff) {
		
		Scanner scanner = new Scanner(System.in);
		List<Employee> employees = new ArrayList<>();
		boolean isValid = true;
		do {

			System.out.println("Employee");
			System.out.println("Enter name");
			employee.setName(scanner.next());
			System.out.println("Enter position");
			employee.setPosition(scanner.next());
			System.out.println("Enter department");
			employee.setDepartment(scanner.next());
			System.out.println("Enter email");
			employee.setEmail(scanner.next());
			System.out.println("Enter age");
			do {
				if(scanner.hasNextInt()) {
					employee.setAge(scanner.nextInt());
					isValid = true;
				}else {
					System.out.println("Please enter correct info!");
					scanner.next();
					isValid = false;
				}
			}while(!isValid);
			System.out.println("Enter salary");
			do {
				if(scanner.hasNextInt()) {
					employee.setSalary(scanner.nextDouble());
					isValid = true;
				}else {
					System.out.println("Please enter correct info!");
					scanner.next();
					isValid = false;
				}
				employees.add(new Employee(employee.name, 
						   employee.salary, 
						   employee.position, 
						   employee.department, 
						   employee.age,
						   employee.email));
			}while(!isValid);
			System.out.println(employee.getName() + "," +
								employee.getSalary() +"," +
								employee.getPosition() + "," +
								employee.getDepartment() + "," +
							    employee.getAge() + ","+ 
								employee.getEmail());
			numberOfStaff--;
		}while(numberOfStaff != 0);
		
		Collections.sort(employees, new Comparator<Employee>() {
			public int compare(Employee emp1, Employee emp2) {
				return (int) (emp1.getSalary() - emp2.getSalary());
			}
		});
		
		for(Employee emp : employees) {
			
			System.out.println(emp.getName() + " " + emp.getSalary() + " " +
							   emp.getPosition() + " " + emp.getDepartment() + " " +
							   emp.getAge() + " " + emp.getEmail());
		}
		
		Collections.sort(employees, new Comparator<Employee>() {
			public int compare(Employee emp1, Employee emp2) {
				return (int) ((int) emp2.getSalary() - emp1.getSalary());
			}
		});
		
		for(Employee emp : employees) {
			
			System.out.println(emp.getName() + " " + emp.getSalary() + " " +
							   emp.getPosition() + " " + emp.getDepartment() + " " +
							   emp.getAge() + " " + emp.getEmail());
		}
	}
}

