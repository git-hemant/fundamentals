package books.cci.ch5;

public class P2_NumberToString {

	public static void main(String[] args) {
		System.out.println("Number: " + 4 + " binary: " + numberToString(4, 1));
		float a = (float) (1.5 - 1.3);
		System.out.println(a);
		System.out.printf("%.2f",a);
		
		int intBits = Float.floatToIntBits(1.1f); 
		String binary = Integer.toBinaryString(intBits);	
		System.out.println("1.1f binary-> " + binary);
	}
	
	private static String numberToString(int n, int base) {
		char[] all = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		char[] str = new char[32];
		int index = 32;
		// Radix means number of unique digits. for e.g. in binary it is 2, in octal it is 8, in Hexadecimal it is 16.
		int radix = (1 << base);
		// Remember mask is radix - 1.
		int mask = radix - 1;
		while (n != 0) {
			// This is important - we are converting from left to right
			// and thus we need to keep moving new bits to right by discarding
			// base bits.
			str[--index] = all[(n & mask)];
			n = n >>> base;
		}
		return new String(str, index, str.length - index);
	}
}
