package Task1_School;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainTest {
	public static void main(String[] args) {
		List<Discipline> disciplines1 = new ArrayList<>();
		disciplines1.add(new Discipline("English", 10));
		disciplines1.add(new Discipline("French", 5));
		disciplines1.add(new Discipline("Spanish", 3));
		
		
		List<Discipline> disciplines2 = new ArrayList<>();
		disciplines2.add(new Discipline("Mathematic", 10));
		disciplines2.add(new Discipline("C# basics", 10));
		disciplines2.add(new Discipline("Java OOP", 10));
		
		List<Classes> classes = new ArrayList<>();
		classes.add(new Classes(1, "A"));
		classes.add(new Classes(1, "B"));
		classes.add(new Classes(1, "C"));

		List<Person> persons = new ArrayList<>();
		persons.add(new Teacher("Ivan", "Ivan", disciplines1));
		persons.add(new Teacher("Peter", "Petrov", disciplines1));
		persons.add(new Teacher("Gergana", "Borisova", disciplines2));
		persons.add(new Teacher("Viyra", "Todorova", disciplines2));
		persons.add(new Student("Georgi", "Gergiev", classes.get(0)));
		persons.add(new Student("Ivaivo", "Ivanov", classes.get(1)));
		persons.add(new Student("Petiya", "Petrova", classes.get(2)));
		 
		
		System.out.println("Teacher " + 
						   persons.get(0).getFirsName() + " " +  
						   persons.get(1).getLastName() + " " +  
						   "Teaches disciplines " + disciplines1.get(0).getNameOfDiscipline() + 
						   " in class " + disciplines1.get(0).getNumberOfHoursOfdisciplinePerWeek() +
						   " hours per week");
									   
	}
}
