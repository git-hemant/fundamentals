package string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//Average word length is K
//Word count is N
//O(N * (K * logK)) 
// Interviewer: Amazon - Scott Bressler
public class AnagramUsingHashMap implements AnagramBase {

	public static void main(String[] args) {
		boolean isAnagram = new AnagramUsingHashMap().isAnagram("aab", "aba");
		// Fail if the above flag is not true.
	}

	
	// Write a method that takes in two strings and returns whether they are
	// anagrams
	// E.g. aab and aba
	public boolean isAnagram(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
		}
		Map<Character, Integer> s1Map = characterMap(s1);
		Map<Character, Integer> s2Map = characterMap(s2);
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


	private static Map<Character, Integer> characterMap(String str) {
		 Map<Character, Integer> map = new HashMap<Character, Integer>(str.length() * 2);
		// Iterate thru the first string
		for (int i = 0; i < str.length(); i++) {
			Integer count = (Integer) map.get(str.charAt(i));
			if (count == null) {
				count = new Integer(1);
			} else {
				count = new Integer(count.intValue() + 1);
			}
			map.put(str.charAt(i), count);
		}

		return map;
	}
};