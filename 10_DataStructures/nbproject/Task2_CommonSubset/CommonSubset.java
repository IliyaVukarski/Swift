package Task2_CommonSubset;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CommonSubset {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean isValid = true;
		int numberOfSamples1 = 0;
		int numberOfSamples2 = 0;
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		do {
			System.out.println("Enter number of Samples for set 1");
			System.out.println("Enter number of Samples for set 2");
			if(scanner.hasNextInt()) {
				
				numberOfSamples1 = scanner.nextInt();
				numberOfSamples2 = scanner.nextInt();
				isValid = true;
				System.out.print("Enter numbers for set 1");
				for(int index = 0; index < numberOfSamples1; index++) {
					do {
						if(scanner.hasNextInt()) {
							set1.add(scanner.nextInt());
							isValid =true;
						}else {
							System.out.print("Enter valid numbers");
							isValid = false;
							scanner.next();
						}
					}while(!(isValid));
				}
				
				System.out.print("Enter numbers for set 2");
				for(int index = 0; index < numberOfSamples2; index++) {
					do {
						if(scanner.hasNextInt()) {
							set2.add(scanner.nextInt());
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
		
		set1.retainAll(set2);
		System.out.println(set1);
	}
}
