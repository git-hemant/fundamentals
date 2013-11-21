package books.cci.ch5;

/**
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j.
 * Write a method to set all bits between i and j in N equal to M (e.g., M
 * becomes a substring of N located at i and starting at j). EXAMPLE: Input: N =
 * 10000000000, M = 10101, i = 2, j = 6 Output: N = 10001010100
 */
public class P1 {

	public static void main(String[] args) {
		int N = 1040;
		int M = 21;
		int i = 2;
		int j = 6;
		System.out.println("Before N=" + N + " binary: " + Integer.toBinaryString(N));
		System.out.println("Before M=" + M + " binary: " + Integer.toBinaryString(M));
		int output = updateBits(N, M, i, j);
		System.out.println("Output number=" + output + " binary: " + Integer.toBinaryString(output));
	}
	
	public static int updateBits(int n, int m, int i, int j) {
		//~0 means -1 where all bits are 1 as compliment
		// operator invert the bits.
		int max = ~0; /* All 1’s */

		// 1’s through position j, then 0’s
		int left = max - ((1 << j) - 1);

		// 1’s after position i
		int right = ((1 << i) - 1);

		// 1’s, with 0s between i and j
		int mask = left | right;
		
		// Clear i through j, then put m in there
		return (n & mask) | (m << i);
	}
}
