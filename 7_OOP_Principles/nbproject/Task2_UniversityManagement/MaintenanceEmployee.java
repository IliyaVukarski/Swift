package Task2_UniversityManagement;

public class MaintenanceEmployee extends Employee {
	
	public MaintenanceEmployee(String name, String telephoneNumber) {
		super(name, telephoneNumber, 15);
	}
	
	public double work(Person[] people, int peopleCount) {
		for(int index = 0; index < peopleCount; index++) {
			people[index].increaseTolerance(2);
		}
		return -this.getHourRate();
	}
}
