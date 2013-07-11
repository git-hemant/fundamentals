package interview.amzn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//Average word length is K
//Word count is N
//O(N * (K * logK)) 
// Interviewer: Scott Bressler
public class CheckForAnagram {

	public static void main(String[] args) {
		boolean isAnagram = isAnagram("aab", "aba");
		// Fail if the above flag is not true.
	}

	// Write a method that takes in two strings and returns whether they are
	// anagrams
	// E.g. aab and aba
	public static boolean isAnagram(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
		}

		Map<Character, Integer> s1Map = new HashMap<Character, Integer>(
				s1.length() * 2);
		Map<Character, Integer> s2Map = new HashMap<Character, Integer>(
				s2.length() * 2);

		// Iterate thru the first string
		for (int i = 0; i < s1.length(); i++) {
			Integer count = (Integer) s1Map.get(s1.charAt(i));
			if (count == null) {
				count = new Integer(1);
			} else {
				count = new Integer(count.intValue() + 1);
			}
			s1Map.put(s1.charAt(i), count);
		}

		// Iterate thru the second string
		for (int i = 0; i < s2.length(); i++) {
			Integer count = (Integer) s2Map.get(s2.charAt(i));
			if (count == null) {
				count = new Integer(1);
			} else {
				count = new Integer(count.intValue() + 1);
			}
			s2Map.put(s2.charAt(i), count);
		}

		// Check the map size.
		if (s1Map.size() != s2Map.size()) {
			return false;
		}

		// Iterate thru the map and return false as soon as we have any
		// mis-match.
		for (Iterator<Character> iterator = s1Map.keySet().iterator(); iterator.hasNext();) {
			Object key = iterator.next();
			// First check, if this key exist in second string.
			if (s2Map.get(key) == null) {
				return false;
			}
			Integer value1 = s1Map.get(key);
			Integer value2 = s2Map.get(key);
			if (!value1.equals(value2)) {
				return false;
			}
		}

		return true;
	}
}