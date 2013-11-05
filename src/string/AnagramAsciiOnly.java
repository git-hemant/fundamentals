package string;

public class AnagramAsciiOnly implements AnagramBase {

	public boolean isAnagram(String s1, String s2) {
		if (s1 != null && s2 != null && s1.length() == s2.length()) {
			int[] charCount = new int[256];
			
			// Now first iterate thru first string, and increment counter for each character in the string.
			for (int i = 0; i < s1.length(); i++) {
				int index = s1.charAt(i); 
				charCount[index]++;
			}
			for (int i = 0; i < s2.length(); i++) {
				int index = s2.charAt(i); 
				charCount[index]--;
			}
			// Now scan and look if we have any non-zero value anywhere.
			for (int i = 0; i < charCount.length; i++) {
				if (charCount[i] != 0) return false;
			}
			return true;
		}
		return false;
	}

}
