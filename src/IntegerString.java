
public class IntegerString {

	public static void main(String[] args) {
		System.out.println("Hella".compareTo("Hello"));
		System.out.println(integerToString(-5, 1));
		System.out.println(integerToString(150, 4));
		System.out.println(integerToString(150, 3));
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
