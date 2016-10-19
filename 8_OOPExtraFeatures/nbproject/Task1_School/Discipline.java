package Task1_School;

public class Discipline  {

	private String nameOfDiscipline;
	private int numberOfHoursOfdisciplinePerWeek;
	
	public Discipline(String nameOfDiscipline, int numberOfHoursOfdisciplinePerWeek) {

		this.setNameOfDiscipline(nameOfDiscipline);
		this.setNumberOfHoursOfdisciplinePerWeek(numberOfHoursOfdisciplinePerWeek);
	}

	public int getNumberOfHoursOfdisciplinePerWeek() {
		return numberOfHoursOfdisciplinePerWeek;
	}
	
	public String getNameOfDiscipline() {
		return nameOfDiscipline;
	}
	
	public void setNumberOfHoursOfdisciplinePerWeek(int numberOfHoursOfdisciplinePerWeek) {
		this.numberOfHoursOfdisciplinePerWeek = numberOfHoursOfdisciplinePerWeek;
	}

	public void setNameOfDiscipline(String nameOfDiscipline) {
		this.nameOfDiscipline = nameOfDiscipline;
	}
}
