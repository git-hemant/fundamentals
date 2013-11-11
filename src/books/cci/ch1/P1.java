package books.cci.ch1;

/**
 * Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?
 * Time complexity O(N) & Space complexity O(N)
 * 
 * Assumption: Input string contains only the ASCII characters (256 characters)
 * 
 * More info: ASCII A => 65, Z => 90, a => 97, z => 122.
 */
public class P1 {
	
	private static final String INPUT = "brownfOx";
	
	public static void main(String[] args) {
		boolean b = isUnique(INPUT);
		System.out.println("Input: " + INPUT + " [all unique: " + b + "]");
	}
	
	private static boolean isUnique(String input) {
		// We will flag any character which find using character ASCII index
		// this way we will know when we see the same character second time
		// We can also use here BitSet instead of boolean which is one byte.
		boolean[] b = new boolean[256];
		for (int i = 0; i < input.length(); i++) {
			// If we are seeing this character second time, than ignore it.
			if (b[input.charAt(i)]) {
				System.out.println("Character: " + input.charAt(i) + " is repeated.");
				return false;
			}
			
			b[INPUT.charAt(i)] = true;
		}
		return true;
	}
}
