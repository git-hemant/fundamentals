import java.util.Scanner;


// Find all the combinations of given word
// for e.g. cat would result into
// cat act tac tca, etc
public class WordCombinations {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		System.out.println("Combinations of word: " + word);
		char[] wordArray = word.toCharArray();
		for (int i = 0; i < wordArray.length; i++) {
			for (int j = 0; j < wordArray.length; j++) {
				char c = wordArray[j];
				
			}
		}
	}
}
