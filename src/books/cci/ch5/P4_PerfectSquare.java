package books.cci.ch5;

// Explain what the following code does: ((n & (n-1)) == 0).
// Solution: This means the number if perfect square for e.g.
// 8 (1000) & 7 (111) == 0 where 8 is perfect square 4~2
public class P4_PerfectSquare {

	public static void main(String[] args) {
		// Print perfect squre numbers.
		for (int i = 0; i <= Integer.MAX_VALUE; i++) {
			// We need this check to avoid overflow.
			if (i == Integer.MAX_VALUE) {
				break;
			}
			if ((i & (i - 1)) == 0) {
				System.out.println("Number: " + i + " is perfect square. Binary number: " + Integer.toBinaryString(i));
			}
		}
	}
}
