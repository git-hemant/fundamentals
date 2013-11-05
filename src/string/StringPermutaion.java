package string;

import java.util.ArrayList;
import java.util.List;

public class StringPermutaion {

	public static void main(String[] args) {
		String s1 = "hemant";
		List<String> permutations = new ArrayList<String>(factorial(s1.length()));
		showPermutations("", s1, permutations);
		System.out.println(s1 + " permutations: " + permutations.size());
		System.out.println(permutations);
	}
	
	// Runtime is O(factorial(n)) as string with 
	// 3 characters -> 6   permutations [3 X 2 X 1]
	// 4 characters -> 24  permutations [4 X 3 X 2 X 1]
	// 5 characters -> 120 permutations [5 X 4 X 3 X 2 X 1]
	// 6 characters -> 720    permutations [6 X 5 X 4 X 3 X 2 X 1]
	public static void showPermutations(String prefix, String s, List<String> permutations) {
	    // Base condition
		if (s.length() == 0) {
			permutations.add(prefix);
		} else {
			for (int i = 0; i < s.length(); i++)
	        	// Prefix + current, before + after
				showPermutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1), permutations);
		}
	}

	private static int factorial(int n) {
		if (n == 1) {
			return n;
		}
		return n * factorial(n - 1);
	}
}
