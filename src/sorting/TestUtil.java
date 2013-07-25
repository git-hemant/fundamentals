package sorting;

public class TestUtil {

	public static int[] getRandomIntegers(int size) {
		int[] randomNumbers = new int[size];
		for (int i = 0; i < randomNumbers.length; i++) {
			int num = (int) (1000 * (Math.random() + Math.random()));
			randomNumbers[i] = num;
		}
		return randomNumbers;
	}
	
	public static void print(int[] n) {
		int size = n.length % 61;
		
		System.out.println("Total (" + size + ") ");
		
		for (int i = 0; i < size; i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			System.out.print(n[i]);
		}
		System.out.println("\n");
	}
	
	public static void print(Object[] n) {
		int size = n.length % 61;
		
		System.out.println("Total (" + size + ") ");
		
		for (int i = 0; i < size; i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			System.out.print(n[i]);
		}
		System.out.println("\n");
	}
}
