package books.cci.ch2;

/**
 * Implement an algorithm to find the nth to last element of a singly linked list.
 */
public class P1 {

	public static void main(String[] args) {
		// Build linked list
		int data [] = {21, 32, 23, 23, 43, 56, 67, 78};
		int nthFromLast = 3;
		LinkedListNode head = buildLinkedList(data);
		LinkedListNode node = nthFromLast(head, nthFromLast);
		System.out.println(nthFromLast + " from last is: " + node.data);
	}
	
	private static LinkedListNode nthFromLast(LinkedListNode head, int nthFromLast) {
		LinkedListNode n1 = head, n2 = head;
		int counter = 1;
		while (n1 != null) {
			if (counter > nthFromLast) {
				n2 = n2.next;
			}
			n1 = n1.next;
			counter++;
		}
		return n2;
	}


	private static LinkedListNode buildLinkedList(int[] data) {
		LinkedListNode head = null;
		LinkedListNode prev = null;
		for (int i = 0; i < data.length; i++) {
			LinkedListNode node = new LinkedListNode();
			node.data = data[i];
			if (prev != null) {
				prev.next = node;
			}
			
			if (i == 0) {
				head = node;
				prev = head;
			} else {
				prev = node;
			}
			
		}
		return head;
	}



	static class LinkedListNode {
		LinkedListNode next;
		Object data;
	}
}
