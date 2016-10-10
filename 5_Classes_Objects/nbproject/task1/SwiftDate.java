package task1;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class SwiftDate {
	private int year;
	private int month;
	private int day;
	
	public SwiftDate() {
		
	}
	
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
	
	public boolean isLeapYear() {
		if((this.getYear() % 4 == 0) && (this.getYear() % 100 != 0)) {
			return true;
		}else if((this.getYear() % 4 == 0) && (this.getYear() % 100 == 0) && (this.getYear() % 400 == 0)) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getDayDifference() { 
		System.out.println("Enter two dates from the calendar");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter first date");
		String[] dateOne = scanner.nextLine().split(" ");
		int[] arrDateOne = new int[3];
		for(int index = 0; index <dateOne.length; index++) {
			int date = Integer.parseInt(dateOne[index]);
			arrDateOne[index] = date;
		}
		System.out.println("Enter second date");
		String[] dateTwo = scanner.nextLine().split(" ");
		int[] arrDateTwo = new int[3];
		for(int index = 0; index <dateTwo.length; index++) {
			int date = Integer.parseInt(dateTwo[index]);
			arrDateTwo[index] = date;
		}

		int yearsDifference = 0;
		int monthsDifference = 0;
		int daysDifference = 0;
		SwiftDate swiftDate1 = new SwiftDate(arrDateOne[0], arrDateOne[1], arrDateOne[2]);
		SwiftDate swiftDate2 = new SwiftDate(arrDateTwo[0], arrDateTwo[1], arrDateTwo[2]);
		if(swiftDate1.getYear() > swiftDate2.getYear()) {
			yearsDifference = ((arrDateOne[0] - arrDateTwo[0]) * 365);
		}else{
			yearsDifference = ((arrDateTwo[0] - arrDateOne[0]) * 365);
		}
		
		if(swiftDate1.getMonth() > swiftDate2.getMonth()) {
			monthsDifference = ((arrDateOne[1] - arrDateTwo[1]) * 30);
		}else{
			monthsDifference = ((arrDateTwo[1] - arrDateOne[1]) * 30);
		}
		
		if(swiftDate1.getDay() > swiftDate2.getDay()) {
			daysDifference = (arrDateOne[2] - arrDateTwo[2]);
		}else{
			daysDifference = (arrDateTwo[2] - arrDateOne[2]);
		}
		printInfo(swiftDate1);
		printInfo(swiftDate2);
		int difference = yearsDifference + monthsDifference + daysDifference;
		System.out.printf(" %d ", difference);
		return difference;
	}
	
	public int getCentury() {
		int century = 0;
		if(this.getYear() % 100 == 0) {
			century = (this.getYear() / 100);
		}else {
			century = (this.getYear() / 100) + 1;
		}
		return century;
	}
	
	public static void printInfo(SwiftDate swiftDate) {
		swiftDate.getCentury();
		if(swiftDate.isLeapYear()) {
			System.out.printf("%d %d %d - <%d> century. It's a leap year", 
							  swiftDate.getYear(), 
							  swiftDate.getMonth(), 
							  swiftDate.getDay(), 
							  swiftDate.getCentury());
		}else {
			System.out.printf("%d %d %d - <%d> century.", 
							  swiftDate.getYear(), 
							  swiftDate.getMonth(), 
							  swiftDate.getDay(), 
							  swiftDate.getCentury());
		}
	}
}
