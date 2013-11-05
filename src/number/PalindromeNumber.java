package number;

public class PalindromeNumber {

	public static void main(String[] args) {
		System.out.println("isPalindrome(1024): " + isPalindrome(1024));
		System.out.println("isPalindrome(23032): " + isPalindrome(23032));
		System.out.println("isPalindrome(-10301): " + isPalindrome(-10301));
		System.out.println("isPalindrome(2233): " + isPalindrome(2233));
	}
	
	// Test whether given number is palindrom
	// e.g. -10501 is palindrome
	//      10602  is not palindrome
	private static boolean isPalindrome(int n) {
		int orignal = n, reversed = 0;
		while (n != 0) {
			reversed = (reversed * 10) + (n % 10);
			n /= 10;
		}
		return reversed == orignal;
	}
}
