package Task2_UniversityManagement;

import java.util.List;

public abstract class Person {

	private String name;
	private String telephoneNumber;
	protected int individualTolerance;
	
	public Person(String name, String telephoneNumber) {
		this.setName(name);
		this.setTelephoneNumber(telephoneNumber);
		this.setIndividualTolerance(20); 
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public int getIndividualTolerance() {
		return individualTolerance;
	}
	public void setIndividualTolerance(int individualTolerance) {
		this.individualTolerance = individualTolerance;
	}
	
	public void decreaseTolerance(int value) {
		individualTolerance = this.getIndividualTolerance() - value;
	}
	
	public void increaseTolerance(int value) {
		individualTolerance = this.getIndividualTolerance() - value;
	}
	
	public double work(List<Person> people, int peopleCount) {
		return 0;
	}
}