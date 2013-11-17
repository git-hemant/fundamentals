package books.cci.ch5;

public class P3 {
	public static void main(String[] args) {
		int n = 30;
		System.out.println("N=" + n + " binary: " + Integer.toBinaryString(n) + " count of 1 bits: " + count1Bits(n));
		
	}
	
	static int count1Bits(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n >>>= 1;
		}
		return count;
	}
}
