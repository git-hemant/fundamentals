
public class IntegerString {

	public static void main(String[] args) {
		// Show number in binary
		System.out.println("Binary: " + integerToString(15, 1));
		// Show number in Octal
		System.out.println("Octal: " + integerToString(15, 3));
		// Show number in hexadecimal
		System.out.println("Hexadecimal: " + integerToString(15, 4));
	}
	
	private static String integerToString(int n, int base)
	{
		//0 -> 0
		//1 -> 1 # That's why 1 is base for octal number
		//2 -> 10
		//3 -> 11
		//4 -> 100
		//5 -> 101
		//6 -> 110
		//7 -> 111 # That's why 3 is base for octal number
		//8 -> 1000
		//9 -> 1001
		//10-> 1010
		//11-> 1011
		//12-> 1100
		//13-> 1101
		//14-> 1110
		//15-> 1111 # That's why 4 is base for hexadecimal number
		//16-> 10000
		char[] buf = new char[32];
		// 1 << 1 is 2 [For binary]
		// 1 << 3 is 8 [For octal]
		// 1 << 4 is 16[for Hexadecimal]
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
