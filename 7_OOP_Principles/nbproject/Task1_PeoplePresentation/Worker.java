package Task1_PeoplePresentation;

public class Worker extends Person {
	private double weekSalarty;
	private int workHoursPerDay;
	
	public Worker() {
		
	}
	
	public Worker(String firstName, String lastName, double weekSalary, int workHoursPerDay) {
		super(firstName, lastName);
		this.setWeekSalarty(weekSalary);
		this.setWorkHoursPerDay(workHoursPerDay);
	}
	
	public double getWeekSalarty() {
		return weekSalarty;
	}

	public void setWeekSalarty(double weekSalarty) {
		this.weekSalarty = weekSalarty;
	}

	public int getWorkHoursPerDay() {
		return workHoursPerDay;
	}

	public void setWorkHoursPerDay(int workHoursPerDay) {
		this.workHoursPerDay = workHoursPerDay;
	}
	
	public double calculateSalary() {
		double salary = 0;
		int workDaysPerWeek = 5;
		salary = this.getWeekSalarty() / (this.getWorkHoursPerDay() * workDaysPerWeek);
		return salary;
	}
	
}
