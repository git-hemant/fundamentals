
public class IntegerString {

	public static void main(String[] args) {
		// Show number in binary
		System.out.println("Binary: " + integerToString(8, 1));
		// Show number in hexadecimal
		System.out.println("Hexadecimal: " + integerToString(150, 4));
		// Show number in Octal
		System.out.println("Octal: " + integerToString(150, 3));
	}
	
	private static String integerToString(int n, int base)
	{
		char[] buf = new char[32];
		int mask = (1 << base) - 1;
		char[] ALL_NUMBERs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		int pos = 32;
		do {
			buf[--pos] = ALL_NUMBERs[n & mask];
			n = n >>> base;
		} while (n != 0);
		return new String(buf, pos, buf.length - pos);
		
	}
}
