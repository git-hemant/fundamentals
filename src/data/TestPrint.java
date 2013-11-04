package data;

public class TestPrint {

	public static void print(int[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			if (i > 0) System.out.print(", ");
			System.out.print(intArray[i]);
		}
		System.out.println("");
	}
}
