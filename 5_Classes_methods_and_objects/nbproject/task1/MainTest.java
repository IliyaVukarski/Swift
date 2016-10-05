package task1;

public class MainTest {

	public static void main(String[] args) {
		SwiftDate swiftDate = new SwiftDate(2016, 10, 01);
		System.out.println("This year is leap? " + swiftDate.isLeapYear(swiftDate.getYear()));
		swiftDate.getCentury(swiftDate.getYear());
		swiftDate.getCentury(swiftDate.getYear());
		System.out.println();
		swiftDate.printInfo(swiftDate.getYear(), swiftDate.getMonth(), swiftDate.getDay());
		swiftDate.getDayDifference();

	}

}
