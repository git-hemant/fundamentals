import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Anagrams
{
	
	public  static void showStringPermutations(String str) { 
	    showStringPermutations("", str); 
	}

	private static void showStringPermutations(String prefix, String str) {
	    int n = str.length();
	    
	    // Base condition
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	        	// Prefix + current, before + after
	            showStringPermutations(prefix + str.charAt(i), str.substring(i+1) + str.substring(0, i));
	    }
	}
	
	// Write a method that takes in two strings and returns whether they are anagrams
	// E.g. aab and aba
	// Time complexity of this algorithm is O(N)
	public static boolean isAnagram(String s1, String s2) {
	    if (s1 == null || s2 == null || s1.length() != s2.length()) {
	        return false;
	    }
	    
	    Map<Character, Integer> s1Map = new HashMap<Character, Integer>(s1.length() * 2);
	    Map<Character, Integer> s2Map = new HashMap<Character, Integer>(s2.length() * 2);    
	    
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
	    
	    // Iterate thru the map and return false as soon as we have any mis-match.
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
	
	public static void main(String[] args) throws IOException
	{
		showAllCombinations("abc");
		//showStringPermutations("abc");
		//dictionaryAnagram();
		
	}
	
	private static void showAllCombinations(String str) {
		StringBuilder buff = new StringBuilder();
		doCombine(str.toCharArray(), buff, str.length(), 0, 0);
	}
	
	private static void doCombine(char[] instr, StringBuilder outstr, int length, int level, int start) {
		for (int i = start; i < length; i++) {
			outstr.append(instr[i]);
			System.out.println(outstr);
			if (i < (length - 1)) {
				doCombine(instr, outstr, length, level + 1, i + 1);
			}
			
			outstr.setLength(outstr.length() - 1);
		}
		
	}
	
	public static void dictionaryAnagram() throws IOException {
		URL url = new URL("http://andrew.cmu.edu/course/15-121/dictionary.txt");
		Scanner sc = new Scanner( url.openStream() );

		HashMap<String, ArrayList<String>> map =  new HashMap<String, ArrayList<String>>();

		int count = 0;
		while( sc.hasNextLine() )
		{
			count++;
			String word = sc.nextLine();
			String sortedWord = sortString(word); // this is a key

			ArrayList<String> anagrams = map.get( sortedWord );  //this is a value

			if( anagrams == null ) {
				anagrams = new ArrayList<String>();
				map.put(sortedWord, anagrams);
			}

			anagrams.add(word);
		}
		System.out.println("Total words: " + count);
		System.out.println(map.get(sortString("bread")));   //testing

	}
	private static String sortString( String w )
	{
		char[] ch = w.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
}