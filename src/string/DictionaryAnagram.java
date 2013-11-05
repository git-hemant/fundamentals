package string;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DictionaryAnagram {

	public static void main(String[] args) throws IOException {
		System.out.println(lookupDictionaryForAnagrams("cat"));
	}
	
	// Sort every word in the dictionary and keep as <String>[sorted], List<string> [unsorted words]
	// Now sort the key and lookup in the dictionary.
	public static List<String> lookupDictionaryForAnagrams(String key) throws IOException {
		//URL url = new URL("http://andrew.cmu.edu/course/15-121/dictionary.txt");
		Scanner sc = new Scanner( Anagrams.class.getResourceAsStream("dictionary.txt") );
		HashMap<String, List<String>> map =  new HashMap<String, List<String>>();
		int count = 0;
		while( sc.hasNextLine() )
		{
			count++;
			String word = sc.nextLine();
			String sortedWord = sortString(word); // this is a key
			List<String> anagrams = map.get( sortedWord );  //this is a value
			if( anagrams == null ) {
				anagrams = new ArrayList<String>();
				map.put(sortedWord, anagrams);
			}

			anagrams.add(word);
		}
		System.out.println("Total words in dictionary: " + count);
		sc.close();
		return map.get(sortString(key));   //testing
	}

	private static String sortString( String w )
	{
		char[] ch = w.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
	
}
