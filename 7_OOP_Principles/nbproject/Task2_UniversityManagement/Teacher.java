package Task2_UniversityManagement;

public class Teacher extends Employee {
	
	private String[] subject;

	public Teacher(String name, String telephoneNumber, String[] subject) {
		super(name, telephoneNumber, 25);
		this.setSubject(subject);
	}
	
	public String[] getSubject() {
		return subject;
	}

	public void setSubject(String[] subject) {
		this.subject = subject;
	}
	
	public double work(Person[] people, int peopleCount) {
         for(int index = 0; index < peopleCount; index++){
            
            Person someoneOther = people[index];
            
            if(someoneOther instanceof MaintenanceEmployee){
            	someoneOther.decreaseTolerance(3);
            } else if(someoneOther instanceof Student) {
            	someoneOther.increaseTolerance(3);
            } else if(someoneOther instanceof AdministrationEmployee){
            	someoneOther.decreaseTolerance(1);
            }
         }
         
        return - this.getHourRate();
	}

}
