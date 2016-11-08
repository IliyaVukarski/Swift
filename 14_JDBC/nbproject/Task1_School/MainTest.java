package Task1_School;

public class MainTest {

	public static void main(String[] args) {
		MySqlSchoolData mySqlSchoolData = new MySqlSchoolData();
		//mySqlSchoolData.insertDataForTeacher();
		//mySqlSchoolData.getTeachers(1);
		//mySqlSchoolData.getTeachers();
		//mySqlSchoolData.insertDataForStudent();
		//mySqlSchoolData.getStudents();
		mySqlSchoolData.getTeachersAndDisciplines(1);
	}
}
