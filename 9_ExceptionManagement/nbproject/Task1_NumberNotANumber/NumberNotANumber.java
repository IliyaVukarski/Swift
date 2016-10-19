package Task1_NumberNotANumber;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberNotANumber {

	public static void main(String[] args) {
		
		while(true) {
			System.out.println("Enter any value to be parsed to int or END to exit ");
			Scanner scanner = scanner = new Scanner(System.in);
			String exit = scanner.next();
			if(exit.equalsIgnoreCase("END")) {
				break;
			}else {
				List<Integer> list = new ArrayList<>();
				String[] value = exit.split(" ");
				try {
					
					for(int index = 0; index < value.length; index++) {
						int number = Integer.parseInt(value[index]);
						list.add(number);
					}
					for(int num : list) {
						System.out.println(num + " ");
					}
				}catch(NumberFormatException ex) {
					System.out.println("It's not a number!");
				}
			}
		}
	}
}
