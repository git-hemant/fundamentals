import java.util.Scanner;

public class StringToNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a valid number: ");
		String nStr = scanner.nextLine();
		System.out.println("Number is: " + myStrToNumber(nStr));
	}
	
	private static int myStrToNumber(String str) {
		boolean isNeg = str.charAt(0) == '-';
		int n = 0;
		for (int i = isNeg ? 1 : 0; i < str.length(); i++) {
			n = (n * 10) + (str.charAt(i) - '0');
		}
		return isNeg ? (n * -1) : n;
	}
	
	private static int strToNumber(String str) {
		if (str == null || str.trim().length() == 0) {
			throw new IllegalArgumentException("Empty string can't be converted into integer.");
		}
		char[] c = str.toCharArray();
		int number = 0;
		boolean isNegative = c[0] == '-';
		for (int i = 0; i < c.length; i++) {
			if (c[i] >= '0' && c[i] <= '9') {
				number = (number * 10) + c[i] - '0';
			} else {
				throw new IllegalArgumentException("Invalid character: " + c[i] + " in the string " + str);
			}
		}
		if (isNegative) {
			number *= -1;
		}
		return number;
	}
}
