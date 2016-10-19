package Task2_UniversityManagement;

public class AdministrationEmployee extends Employee {
	private String[] subject;
	
	public AdministrationEmployee(String name, String telephoneNumber, String[] subject) {
		super(name, telephoneNumber, 19);
		this.setSubject(subject);
	}
	
	public String[] getSubject() {
		return subject;
	}

	public void setSubject(String[] subject) {
		this.subject = subject;
	}
	
	public double work(Person[] people, int peopleCount) {
		
		for(int index = 0; index < peopleCount; index++) {
			Person someoneOther = people[index];
			if(someoneOther instanceof MaintenanceEmployee) {
				someoneOther.increaseTolerance(1);
			}else if(someoneOther instanceof Teacher || someoneOther instanceof Student) {
				someoneOther.increaseTolerance(3);
			}
			
		}
		return -this.getHourRate();
	}
}
