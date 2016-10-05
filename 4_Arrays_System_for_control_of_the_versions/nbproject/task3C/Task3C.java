package task3C;

import java.util.Scanner;

public class Task3C {

	public static StringBuilder encode(String message) {
		int rightShift = 1;
		StringBuilder stringBuilder = new StringBuilder();
		char ch = ' ';
		for(int index = 0;  index < message.length(); index++) {
			ch = message.charAt(index);
			if(Character.isLetter(ch)) {
				ch = (char) (message.charAt(index) + rightShift);
			}
			if((Character.isLowerCase(message.charAt(index)) && ch > 'z') ||
			   (Character.isUpperCase(message.charAt(index)) && ch > 'Z')) {
				ch = (char) (message.charAt(index) - (26 - rightShift));
			}
			stringBuilder.append(ch);
		}
		return stringBuilder;
	}
	
	public static StringBuilder decode (StringBuilder decriptedMessage) {
		int leftShift = 1;
		StringBuilder stringBuilder = new StringBuilder();
		char ch = ' ';
		for(int index = 0;  index < decriptedMessage.length(); index++) {
			ch = decriptedMessage.charAt(index);
			if(Character.isLetter(ch)) {
				ch = (char) (decriptedMessage.charAt(index) - leftShift);
			}
			if((Character.isLowerCase(decriptedMessage.charAt(index)) && ch < 'a') ||
			   (Character.isUpperCase(decriptedMessage.charAt(index)) && ch < 'A')) {
				ch = (char) (decriptedMessage.charAt(index) + 26 - leftShift);
			}
			stringBuilder.append(ch);
		}
		return stringBuilder;
	}
	public static void main(String[] args) {
		System.out.println("Enter String");
		Scanner scanner = new Scanner(System.in);
		String message = scanner.nextLine();
		StringBuilder criptedMessage = encode(message);
		StringBuilder decriptedMessage = decode(criptedMessage);
		int input = 0;
		do {
			System.out.println("Enter 1 for encode or 2 to decode or 3 to exit");
			input = scanner.nextInt();
			if(input == 1) {
				System.out.println(criptedMessage);
			}else if(input == 2) {
				System.out.println(decriptedMessage);
			}else if(input == 3 ){
				System.out.println("Bye!");
			}else {
				System.out.println("Wrong input!");
			}
		}while(input !=3);
 		
	}
}
