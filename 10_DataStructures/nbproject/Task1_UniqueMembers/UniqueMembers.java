package Task1_UniqueMembers;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueMembers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean isValid = true;
		int numberOfSamples = 0;
		Set<Integer> set = new HashSet<Integer>();
		do {
			System.out.println("Enter number of Samples ");
			if(scanner.hasNextInt()) {
				
				numberOfSamples = scanner.nextInt();
				isValid = true;
				System.out.print("Enter numbers");
				for(int index = 0; index < numberOfSamples; index++) {
					do {
						if(scanner.hasNextInt()) {
							int number = scanner.nextInt();
							set.add(number);
							isValid =true;
						}else {
							System.out.print("Enter valid numbers");
							isValid = false;
							scanner.next();
						}
					}while(!(isValid));
					
				}
			}else {
				System.out.println("Enter new correct value of number of samples");
				isValid = false;
				scanner.next();
			}
		}while(!(isValid));
		for(int element : set) {
			System.out.print(element + " ");
		}
		
	}
}
