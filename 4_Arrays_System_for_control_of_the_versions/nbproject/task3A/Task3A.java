package task3A;

public class Task3A {

	public static void main(String[] args) {
		String message = "alabala";
		int length = message.length();
		boolean isPalindrome = true;
		for(int index = 0; index < length / 2; index++) {
			if(message.charAt(index) == message.charAt(length - index - 1)) {
				isPalindrome = true;
			}else {
				isPalindrome = false;
			}
		}
		System.out.println("The string is palindrome? " + isPalindrome);
	}

}
