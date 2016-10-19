package Task1_PeoplePresentation;

public class Student extends Person {
	
	private String facultyNumber;
	private int lectureCount;
	private int exerciseCount;
	
	public Student() {
		
	}
	
	public Student(String firstName, String lastName, int lectureCount, int exerciseCount) {
		super(firstName, lastName);
		this.setLectureCount(lectureCount);
		this.setExerciseCount(exerciseCount);
	}
	
	public double calculateHoursPerWeek() {
		if(this.getLectureCount() > 0 && this.getExerciseCount() >0) {
			double lecturesCount = this.getLectureCount() * 2;
			double exerciseCount = this.getExerciseCount() * 1.5;
			double total = (lecturesCount + exerciseCount) / 5;
			return total;
		}else{
			System.out.println("Wrong input!");
			return 0;
		}
	}
	
	public String getFacultyNumber() {
		return facultyNumber;
	}
	public void setFacultyNumber(String facultyNumber) {
		this.facultyNumber = facultyNumber;
	}
	public int getLectureCount() {
		return lectureCount;
	}
	public void setLectureCount(int lectureCount) {
		this.lectureCount = lectureCount;
	}
	public int getExerciseCount() {
		return exerciseCount;
	}
	public void setExerciseCount(int exerciseCount) {
		this.exerciseCount = exerciseCount;
	}
	
}
