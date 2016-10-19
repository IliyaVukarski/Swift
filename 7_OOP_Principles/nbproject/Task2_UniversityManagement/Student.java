package Task2_UniversityManagement;

public class Student extends Person {
	
	private String facultyNumber;
	private String[] subjects;
	
	public Student(String name, String telephoneNumber, String facultyNumber, String[] subjects) {
		super(name, telephoneNumber);
		this.setFacultyNumber(facultyNumber);
		this.setSubjects(subjects);
	}

	public String getFacultyNumber() {
		return facultyNumber;
	}

	public void setFacultyNumber(String facultyNumber) {
		this.facultyNumber = facultyNumber;
	}

	public String[] getSubjects() {
		return subjects;
	}

	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}
	
	public double work(Person[] people, int peopleCount) {
		individualTolerance = this.getIndividualTolerance() + 2;
		
		for(int index = 0; index < peopleCount; index++) {
			if(people[index] instanceof MaintenanceEmployee) {
				people[index].decreaseTolerance(index);
			}
		}
		
		if(this.getIndividualTolerance() >= 50) {
			return 10;
		}
		
		return 0;
	}

}
