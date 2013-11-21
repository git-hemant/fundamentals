package books.cci.ch3;

import java.util.Stack;

/**
 * Given a input stack of integers, sort these numbers in ascending order in another 
 * stack.
 */
public class P6_SortingUsingTwoStacks {
	
	public static void main(String[] args) {
		int[] n = new int[]{32, 22, 53, 68};
		Stack<Integer> numbers = new Stack<Integer>();
		for (int i = 0; i < n.length; i++) numbers.add(n[i]);
		System.out.println("Unsorted: " + numbers);
		Stack<Integer> sortedStack = sortStack(numbers);
		System.out.println("Sorted: " + sortedStack);
		System.out.println("Unsorted: " + numbers);
	}

	private static Stack<Integer> sortStack(Stack<Integer> numbers) {
		Stack<Integer> sortedNumbers = new Stack<Integer>();
		while (!numbers.isEmpty()) {
			int tmp = numbers.pop();
			while (!sortedNumbers.isEmpty() && sortedNumbers.peek() > tmp) {
				numbers.push(sortedNumbers.pop());
			}
			sortedNumbers.push(tmp);
		}
		return sortedNumbers;
	}
}
