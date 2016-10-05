package task1;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class SwiftDate {
	
	private int year;
	private int month;
	private int day;
	
	public SwiftDate(int year, int month, int day) {
		this.setYear(year);
		this.setMonth(month);
		this.setDay(day);
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public static boolean isLeapYear(int year) {
		if((year % 4 == 0) && (year % 100 !=0)) {
			return true;
		}else if((year % 4 == 0) && (year % 100 == 0) && (year % 400 ==0)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static int getCentury(int year) {
		int century = 0;
		if(year % 100 == 0) {
			century = (year / 100);
		}else {
			century = (year / 100) + 1;
		}
		System.out.printf("It' s %s century ", century);
		return century;
	}
	
	public static int getDayDifference() {
	
		GregorianCalendar date1 = new GregorianCalendar();
		GregorianCalendar date2 = new GregorianCalendar();
		System.out.println("Enter two dates from the calendar");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter first date");
		String[] dateOne = scanner.nextLine().split(" ");
		int[] arrDateOne = new int[3];
		for(int index = 0; index <dateOne.length; index++) {
			int date = Integer.parseInt(dateOne[index]);
			arrDateOne[index] = date;
		}
		printInfo(arrDateOne[0], arrDateOne[1], arrDateOne[2]);
		System.out.println("Enter second date");
		String[] dateTwo = scanner.nextLine().split(" ");
		int[] arrDateTwo = new int[3];
		for(int index = 0; index <dateTwo.length; index++) {
			int date = Integer.parseInt(dateTwo[index]);
			arrDateTwo[index] = date;
		}
		printInfo(arrDateTwo[0], arrDateTwo[1],arrDateTwo[2]);
		date1.set(arrDateOne[0], arrDateOne[1], arrDateOne[2]);
		date2.set(arrDateTwo[0], arrDateTwo[1], arrDateTwo[2]);
		Date d1 = date1.getTime();
		Date d2 = date2.getTime();
		int difference = (int) ((d1.getTime() - d2.getTime()) / (1000 * 60  * 60  * 24));
 		 
		System.out.println(Math.abs(difference));
		return difference;
	}
	
	public static void printInfo(int year, int month, int day) {
		int century = 0;
		if(year % 100 == 0) {
			century = (year / 100);
		}else {
			century = (year / 100) + 1;
		}
		if(isLeapYear(year)) {
			System.out.printf("%d %d %d - <%d> century. [It's a Wleap year]", 
							  year, month, day, century);
		}else {
			System.out.printf("%d %d %d - <%d> century.", 
							  year, month, day, century);
		}
	}
}

