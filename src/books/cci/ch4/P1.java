package books.cci.ch4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Implement a function to check if a tree is balanced. For the purposes of this
 * question, a balanced tree is defined to be a tree such that no two leaf nodes
 * differ in distance from the root by more than one.
 * 
 * The idea is very simple: the difference of min depth and max depth should not
 * exceed 1, since the difference of the min and the max depth is the maximum
 * distance difference possible in the tree. *
 */
public class P1 {

	public static void main(String[] args) {
		new P1().run();
	}
	
	private void run() {
		/*
		 * Create following BST
		 *      5 
		 *     / \
		 *    4   7
		 *       / \
		 *      6   9
		 *         /
		 *        8
		 *        
		 * Max depth is 4 (5 -> 7 -> 9 -> 8)
		 * Min depth is 2 (5 -> 4)        
		 */	
		Node n6 = new Node(6, null, null);
		Node n4 = new Node(4, null, null);		
		Node n8 = new Node(8, null, null);
		Node n9 = new Node(9, n8, null);		
		Node n7 = new Node(7, n6, n9);
		Node root = new Node(5, n4, n7);
		
		System.out.println("Max depth is: " + maxDepth(root));
		System.out.println("Max depth (without recursion) is: " + maxDepthWithoutRecursion(root));
		System.out.println("Max depth2 is: " + maxDepth2(root));
		System.out.println("Min depth is: " + minDepth(root));
	}
	
	// Very interesting function - It uses recursion plus DFS approach
	private static int maxDepth(Node node) {
		if (node == null) return 0;
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right)); 
	}

	// Very interesting function
	private static int minDepth(Node node) {
		if (node == null) {
			return 0;
		}
		int minDepth = Math.min(minDepth(node.left), minDepth(node.right)); 
		return 1 + minDepth; 
	}
	
	static int maxDepth2 (Node r) {
	    int depth = 0;
	    Stack<Node> wq = new Stack<>();
	    Stack<Node> path = new Stack<>();

	    wq.push (r);
	    while (!wq.empty()) {
	        r = wq.peek();
	        if (!path.empty() && r == path.peek()) {
	            if (path.size() > depth)
	                depth = path.size();
	            path.pop();
	            wq.pop();
	        } else {
	            path.push(r);
	            if (r.right != null)
	                wq.push(r.right);
	            if (r.left != null)
	                wq.push(r.left);
	        }
	    }

	    return depth;
	}	
	
	private static int maxDepthWithoutRecursion(Node node) {
		// Assumption - we are assuming no cycle exist in the tree.
		int maxDepth = 0;
		Stack<Node> s = new Stack<Node>();
		List<Node> visitedNodes = new ArrayList<Node>();
		Node n = node;
		s.push(n);
		while (!s.isEmpty() && (n = s.peek()) != null) {
			if (s.size() > maxDepth) {
				maxDepth = s.size();
			}
			visitedNodes.add(n);
			if (n.left != null && !visitedNodes.contains(n.left)) {
				s.add(n.left);
				n = n.left;
				// Continue iteration without removing parent from stack.
				continue;
			}
			if (n.right != null && !visitedNodes.contains(n.right)) {
				s.add(n.right);
				n = n.right;
				// Continue iteration without removing parent from stack.
				continue;
			}
			// Remove the node now from stack.
			s.pop();
		}
		return maxDepth;
	}
	
	class Node {
		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		int data;
		Node left;
		Node right;
		public String toString() { return Integer.toString(data); }
	}
}
