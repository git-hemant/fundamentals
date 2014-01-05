package books.cci.ch2;

// Based on tortoise and hare approach
public class P5_LinkedListCircularRef {
	
	public static void main(String[] args) {
		LinkedListNode head = buildLinkedList();
		LinkedListNode node = findCircularRef(head);
		System.out.println("Overlapping node: " + node.data);
	}
	
	private static LinkedListNode findCircularRef(LinkedListNode head) {
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			System.out.println("Fast: " + fast + " slow: " + slow);
			if (slow == fast) {
				break;
			}
		}
		
		// If there is no circular reference - return null.
		if (fast.next == null) return null;
		
		// At this point we are sure that circular ref exist.
		// Now we will find the node where it start.
		
		// Start the slow pointer at head, and keep 
		// moving both till they meet
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
			System.out.println("2 -> Fast: " + fast + " slow: " + slow);
		}
		return fast;
	}

	private static LinkedListNode buildLinkedList() {
		// A -> B -> C -> D -> E -> C [the same C as earlier]
		LinkedListNode nodeE = new LinkedListNode("E");
		LinkedListNode nodeD = new LinkedListNode("D"); nodeD.next = nodeE;
		LinkedListNode nodeC = new LinkedListNode("C"); nodeC.next = nodeD;
		LinkedListNode nodeB = new LinkedListNode("B"); nodeB.next = nodeC;
		LinkedListNode nodeA = new LinkedListNode("A"); nodeA.next = nodeB;
		nodeE.next = nodeC;
		return nodeA;
	}

	static class LinkedListNode {
		LinkedListNode(Object data) { this.data = data; }
		public String toString() { return data.toString(); }
		LinkedListNode next;
		Object data;
	}
}
