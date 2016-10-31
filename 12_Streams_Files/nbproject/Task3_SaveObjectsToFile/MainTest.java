package Task3_SaveObjectsToFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Savepoint;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainTest {

	public static void main(String[] args) {
		List<String> userCommands = new ArrayList<>();
		userCommands.add("PUT");
		userCommands.add("LOAD");
		userCommands.add("END");
		List<SaveObjectsToStream> movies = new ArrayList<SaveObjectsToStream>();
		SaveObjectsToStream movie = null;
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("PUT, LOAD, END");
			String[] command = scanner.next().split(" ");
			if(command[0].equalsIgnoreCase(userCommands.get(0))) {
				System.out.println("Enter title");
				String title = scanner.next();
				System.out.println("Enter director");
				String director = scanner.next();
				System.out.println("Enter actors using ',' ");
				String[] actors = scanner.next().split(",");
				StringBuilder stringBuilder = new StringBuilder();
				for(int index = 0; index < actors.length; index++) {
					String actor = actors[index];
					stringBuilder.append(actor + " ");
				}
				String[] listOfActors = stringBuilder.toString().split(" ");
				System.out.println("Enter releaseDate: year-month-day");
				String[] date = scanner.next().split("-");
				int[] dateArray = new int[3];
				for(int index = 0; index < date.length; index++) {
					int number = Integer.parseInt(date[index]);
					dateArray[index] = number;
				}
				int year = dateArray[0];
				int month = dateArray[1];
				int day = dateArray[2];
				LocalDate localDate = LocalDate.of(year, month, day);
				
				movie = new SaveObjectsToStream(title, director, listOfActors, localDate);
				movies.add(movie);
				
				movie.saveDataToRepository(movies);
			}else if(command[0].equalsIgnoreCase(userCommands.get(1))) {
				movie.loadDataToRepository();
			}else if(command[0].equalsIgnoreCase(userCommands.get(2))) {
				break;
			}else {
				System.out.println("Wrong input!");
			}
		}
	}
}