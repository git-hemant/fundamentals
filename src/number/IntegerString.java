package number;

public class IntegerString {

	public static void main(String[] args) {
		int[] numbers = {50, 252, 23, (int)Math.pow(2, 22), 65, 19, -33, 33423, 234, -23525};
		//int[] numbers = {50};
		for (int i = 0; i < numbers.length; i++) {
			int n = numbers[i];
			String binary = integerToString(n, 1);
			String octal = integerToString(n, 3);
			String hexa = integerToString(n, 4);
			System.out.println("Number: " + n + "\t binary: " + binary + "\t Octal: " + octal + "\t Hexadecimal: " + hexa);
			if (!binary.equals(Integer.toBinaryString(n))) {
				System.out.println("Invalid binary conversion for n: " + n + " correct is: " + Integer.toBinaryString(n));
			}
			if (!octal.equals(Integer.toOctalString(n))) {
				System.out.println("Invalid octal conversion for n: " + n + " correct is: " + Integer.toOctalString(n));
			}
			if (!hexa.equals(Integer.toHexString(n))) {
				System.out.println("Invalid hexa conversion for n: " + n + " correct is: " + Integer.toHexString(n));
			}
		}
	}
	
	private static String integerToString(int n, int base)
	{
		//0 -> 0
		//1 -> 1 # That's why 1 is base for binary number
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
		int radix = (1 << base) - 1;
		char[] ALL_NUMBERs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		int pos = 32;
		do {
			// We are using & with mask so that we can AND against last bits of the number. 
			buf[--pos] = ALL_NUMBERs[n & radix];
			// Now discard the bit which we have tested.
			// Warning: Here we must NOT use >> but >>> otherwise in case of negative
			// numbers we will run into infinite loop.
			n = n >>> base;
		} while (n != 0);
		return new String(buf, pos, buf.length - pos);
		
	}
}
