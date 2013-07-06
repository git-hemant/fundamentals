package sorting;

public class TestUtil {

	public static int[] getRandomIntegers(int size) {
		int[] randomNumbers = new int[size];
		for (int i = 0; i < randomNumbers.length; i++) {
			int num = (int) (10000 * (Math.random() + Math.random()));
			randomNumbers[i] = num;
		}
		return randomNumbers;
	}
	
	public static void print(int[] n) {
		int size = n.length % 61;
		for (int i = 0; i < size; i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			System.out.print(n[i]);
		}
		System.out.println("\n");
	}
}
