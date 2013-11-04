package linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListNthFromEnd {
	
	public static void main(String[] args) {

		int nTh = 4;
		int[] numbers = { 3, 6, 9, 94, 35, 23, 23, 53, 743, 623,73, 32, 9562, 32,  3561, 64, 62, 6235};
		LinkedList linkedList = new LinkedList();
		for (int i = 0; i < numbers.length; i++) {
			linkedList.add(Integer.valueOf(numbers[i]));
		}
		
		int nthNumberValue = findNthElement(linkedList, nTh);
		System.out.println("Nth number value: " + nthNumberValue);
	}

	private static int findNthElement(LinkedList linkedList, int nTh) {
		int counter = 0;
		Integer nthElement = null;
		for (Iterator<Integer> iterator = linkedList.iterator(), nthIterator = linkedList.iterator(); iterator.hasNext();) {
			// Move the first iterator
			iterator.next();
			if (counter < (nTh - 1)) {
				counter++;
			} else {
				nthElement = nthIterator.next();
			}
			
		}
		//linkedList.e
		return nthElement;
	}
}
