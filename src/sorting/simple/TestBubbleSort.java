//
// $Id: $
//
// Copyright (1997-2011),Fair Isaac Corporation. All Rights Reserved.
//

package sorting.simple;

public class TestBubbleSort
{
	public static void main(String[] args)
	{
		int[] intArray = data.TestData.intArray(20);
		doSort(intArray);
		data.TestPrint.print(intArray);
	}
	
	private static void doSort(int[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			for (int j = 0, size = intArray.length - i; j < size; j++) {
				if (intArray[i] > intArray[j]) {
					swap(intArray, i, j);
				}
			}
		}
	}

	private static void swap(int[] intArray, int i, int j) {
		int temp = intArray[i];
		intArray[i] = intArray[j];
		intArray[j] = temp;
	}
}
