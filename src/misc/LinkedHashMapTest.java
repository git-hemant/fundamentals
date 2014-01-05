package misc;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {
	public static void main(String[] args) {
		putOrder();
		accessOrder();
	}
	
	private static void putOrder() {
		System.out.print("Put order: ");
		// LinkedHashMap preserves the order in which values are put.
		LinkedHashMap<Character, Boolean> linkedMap = new LinkedHashMap<>();
		for (int i = 0; i < 26; i++) 
			linkedMap.put(new Character((char)('A' + i) ), Boolean.TRUE);

		for (int i = 0; i < 26; i++) 
			linkedMap.put(new Character((char)('Z' - i) ), Boolean.TRUE);
		
		// Now it will display the put order and not access order.
		for (Character c : linkedMap.keySet()) {
			System.out.print(c);System.out.print(" ");
		}
	}
	
	private static void accessOrder() {
		System.out.println(""); System.out.print("Access order: ");
		// Modify LinkedHashMap arguments to keep the access order.
		LinkedHashMap<Character, Boolean> linkedMap = new LinkedHashMap<>(52, 1.0f, true);
		for (int i = 0; i < 26; i++) 
			linkedMap.put(new Character((char)('A' + i) ), Boolean.TRUE);

		for (int i = 0; i < 26; i++) 
			linkedMap.put(new Character((char)('Z' - i) ), Boolean.TRUE);
		
		// Now it will display the access order and not access order.
		for (Character c : linkedMap.keySet()) {
			System.out.print(c);System.out.print(" ");
		}
	}
	
}
