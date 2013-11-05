package string;

public class AnagramTest {

	private AnagramBase anagram = new AnagramUsingSort();
	public static void main(String[] args) {
		new AnagramTest().test();
	}
	
	private void test() {
		testAnagram("AMY", "MAY");
		testAnagram("ARMY", "MARY");
		testAnagram("CAT", "CAU");
		testAnagram("Amy", "May");
	}
	
	private void testAnagram(String s1, String s2) {
		boolean result =  anagram.isAnagram(s1, s2);
		System.out.println(s1 + " -> " + s2 + " isAnagram: " + result);
	}
}
