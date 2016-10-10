package taks3;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String personName;
	private double personBalance;
	
	public Person() {
		
	}
	
	public Person(String personName, double personBalance) {
		this.setPersonName(personName);
		this.setPersonBalance(personBalance);
	}

	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public double getPersonBalance() {
		return personBalance;
	}
	public void setPersonBalance(double personBalance) {
		if(personBalance > 0) {
			this.personBalance = personBalance;
		}
	}

}
