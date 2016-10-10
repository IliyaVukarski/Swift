package task1;

import java.util.List;
import java.util.Scanner;

public class CredentialsManager {
	private Credentials credential;
	private List<Credentials> repository; 

	public CredentialsManager() {
		
	}
	
	public CredentialsManager(Credentials credential, List<Credentials> repository) {
		this.setCredential(credential);
		this.setRepository(repository);
	}

	public Credentials getCredential() {
		return credential;
	}
	
	public List<Credentials> getRepository() {
		return repository;
	}

	public void setRepository(List<Credentials> repository) {
		this.repository = repository;
	}

	public void setCredential(Credentials credential) {
		this.credential = credential;
	}

	public void addnewUser(Credentials credentials) {
		repository.add(new Credentials(credentials.getUsername(), credentials.getPassword()));
		System.out.printf("Successufully added to database new user %s ", credentials.getUsername());
		System.out.println();
		for(Credentials cr : repository) {
			System.out.println(cr.getUsername() + " " + cr.getPassword());
		}
	}
	
	public void changeUserPassword(Credentials credentials) {
		for(int index = 0; index < repository.size(); index++) {
			if(repository.get(index).getUsername().equalsIgnoreCase(credentials.getUsername()) &&
			   repository.get(index).getPassword().equalsIgnoreCase(credentials.getPassword())) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Please enter new Password");
				String newPassword = scanner.next();
				repository.get(index).setPassword(newPassword);
				System.out.printf("The user %s has successfully changed his password!", repository.get(index).getUsername());
			}else {
				System.out.println("Passwords don't match!");
			}
		}
	}
	
	public void authorizeUser(List<Credentials> repository, Credentials credentials) {
		for(int index = 0; index < repository.size(); index++) {
			if(repository.get(index).getUsername().equalsIgnoreCase(credentials.getUsername()) &&
			   repository.get(index).getPassword().equalsIgnoreCase(credentials.getPassword())) {
				System.out.println("Access granted");
			}else {
				System.out.println("Access denied");
			}
		}
	}

	public void getUserCommand(String userInputCommand, Credentials credentials) {
		if(userInputCommand.equalsIgnoreCase("ENROLL")) {
			this.addnewUser( credentials);
		}else if(userInputCommand.equalsIgnoreCase("CHPASS")) {
			this.changeUserPassword(credentials);
		}else if(userInputCommand.equalsIgnoreCase("AUTH")) {
			this.authorizeUser(repository, credentials);
		}else {
			System.out.println("Error! Unknown command");
		}
	}
}
