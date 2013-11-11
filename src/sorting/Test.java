package sorting;

import sorting.complex.MergeSort;
import data.TestData;
import data.TestPrint;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] testData = TestData.intArray(10);
		MergeSort ms = new MergeSort();
		//testData = ms.sort(testData);
		//TestPrint.print(testData);
		
		//System.out.println("Divisions: " + ms.getDivisions() + " Iterations: " + ms.getIterations() + " New arrays:" + ms.getNewArrays());
		System.out.println("Factorial of 6: " + factorial(6));
	}

	private static int factorial(int n) {
		if (n == 1) return n;
		return factorial(n - 1) * n;
	}
}
