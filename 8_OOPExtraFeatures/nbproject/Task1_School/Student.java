package Task1_School;

public class Student extends Person {
	private String number;
	private Classes classes;
	
	public Student() {
		
	}
	
	public Student(String firsName, String lastName, Classes classes) {
		super(firsName, lastName);
		this.setClasses(classes);
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
}
