package Task2_UniversityManagement;

public class Employee extends Person {
	private double hourRate;
	
	public Employee(String name, String telephoneNumber, double hourRate) {
		super(name, telephoneNumber);
		this.setHourRate(hourRate);
	}
	
	public double getHourRate() {
		return hourRate;
	}

	public void setHourRate(double hourRate) {
		this.hourRate = hourRate;
	}
}
