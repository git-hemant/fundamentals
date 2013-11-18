package books.cci.ch5;

// Write a function to determine the number of bits required to convert integer A to integer B.
// Input: 31, 14  - Binary for 31 is 11111 and Binary for 14 is 1110
// Output: 2
public class P5 {

	public static void main(String[] args) {
		int a = 31; int b = 14;
		System.out.println("a=" + a + " binary: " + Integer.toBinaryString(a));
		System.out.println("b=" + b + " binary: " + Integer.toBinaryString(b));
		System.out.println("Bit difference is: " + countDifferentBits(a, b));
	}
	
	private static int countDifferentBits(int a, int b) {
		int count = 0;
		// We are starting with i which have bits set to 1 
		// which is 1 only at either in a or b, as bits
		// which was 1 in common locations is crossed out.
		for (int i = (a ^ b); i != 0; i >>>= 1) {
			// Now count all the 1 bit's. Her we can ignore the zero bit
			// difference, because it would be different because each
			// 1 bit on both side became zero now, so we will count only
			// bits which are 1 now.
			count += (i & 1);
		}
		return count;
	}
}
