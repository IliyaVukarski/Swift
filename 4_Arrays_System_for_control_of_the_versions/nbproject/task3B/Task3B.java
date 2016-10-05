package task3B;

import java.util.HashMap;
import java.util.Map;

public class Task3B {

	public static void main(String[] args) {
		String message = "Programming";
		char ch = ' ';
		Map<Character, Integer> numberCharacters = 
				new HashMap<>(Math.min(message.length(), 26));	
		for(int index = 0; index < message.length(); ++index) {
			ch = message.charAt(index);
			if(!numberCharacters.containsKey(ch)) {
				numberCharacters.put(ch, 1);
			}else {
				numberCharacters.put(ch, numberCharacters.get(ch) + 1);
			}
		}
		System.out.println(numberCharacters);
	}
}
