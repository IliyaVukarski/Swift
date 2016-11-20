import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1_FilterFiles {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList();
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Type or end?");
			String command = scanner.next();
			if(command.equalsIgnoreCase("Type")) {
				System.out.println("Enter name of file");
				list.add(scanner.next());
			}else if(command.equalsIgnoreCase("END")) {
				break;
			}
		}
		list.stream().filter(x -> x.endsWith(".png") || 
								  x.endsWith(".jpg") || 
								  x.endsWith(".bmp") || 
								  x.endsWith(".gif"))
					 .forEach(x -> System.out.println(x.toString()));
	}	
}
