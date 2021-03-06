package Task3_CredentialsManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.omg.IOP.CodecPackage.FormatMismatch;

public class RepositoryMain {

	public static void main(String[] args) {
		List<Credentials> repository = new ArrayList<>();
		Credentials credentials = null;
		CredentialsManager credentialsManager = null; 
		Scanner scanner = new Scanner(System.in);
		String userInputCommand = null;
		while(true) {
			
			System.out.println("PLease enter one of these operations:");
			System.out.println("Please choose commands between ENROLL, CHPASS, AUTH, END");
			System.out.println("ENROLL - adds new user, CHPASS - change password user");
			System.out.println("AUTH - check password or END - exits the program");
			userInputCommand = scanner.next();
			if(userInputCommand.equalsIgnoreCase("END")) {
				break;
			}
			
			System.out.println("Enter userName and password");
			String username = null;
			String password = null;
			try {
				username = scanner.next();
				password = scanner.next();
				
			}catch(Exception ex) {
				System.out.println("You entered wrong input");
			}
			credentials = new Credentials(username, password);
			credentialsManager = new CredentialsManager(credentials, repository);
			credentialsManager.getUserCommand(userInputCommand, credentials);
		}
 
	}
}
