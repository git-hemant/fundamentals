package string;

import java.util.Arrays;

public class AnagramUsingSort implements AnagramBase {

	/**
	 * Running time is O(N LogN)
	 * Space complexity is N
	 */
	public boolean isAnagram(String s1, String s2) {
		if (s1 != null && s2 != null && s1.length() == s2.length()) {
			char[] c1 = s1.toCharArray(); 
			Arrays.sort(c1);
			
			char[] c2 = s2.toCharArray();
			Arrays.sort(c2);
			
			for (int i = 0; i < c1.length; i++) {
				if (c1[i] != c2[i]) {
					return false;
				}
			}
			// If we reach here - than it is anagram.
			return true;
		}
		return false;
	}
	
}
