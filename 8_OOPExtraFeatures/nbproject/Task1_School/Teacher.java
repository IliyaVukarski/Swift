package Task1_School;

import java.util.List;

public class Teacher extends Person {
	private List<Discipline> disciplines;

	public Teacher(String firsName, String lastName, List<Discipline> disciplines) {
		super(firsName, lastName);
		this.setDisciplines(disciplines);
	}
	
	public List<Discipline> getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(List<Discipline> disciplines) {
		this.disciplines = disciplines;
	}


}
