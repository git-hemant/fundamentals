package books.cci.ch4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import books.cci.util.BinaryTree.TreeNode;

/**
 * Implement a function to check if a tree is balanced. For the purposes of this
 * question, a balanced tree is defined to be a tree such that no two leaf nodes
 * differ in distance from the root by more than one.
 * 
 * The idea is very simple: the difference of min depth and max depth should not
 * exceed 1, since the difference of the min and the max depth is the maximum
 * distance difference possible in the tree.
 */
public class P1_BSTBalanced {

	public static void main(String[] args) {
		new P1_BSTBalanced().run();
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
		System.out.println("Max depth (without recursion) is: " + maxDepthNoRecursion(root));
		System.out.println("Min depth is: " + minDepth(root));
		System.out.println("Min depth (without recursion) is: " + minDepthNoRecursion(root));
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
		return 1 + Math.min(minDepth(node.left), minDepth(node.right)); 
	}
	
	// Find the maximum depth in the tree without using recursion
	private static int maxDepthNoRecursion(Node root) {
		return Math.max(maxDepthNoRecursion(root, true), maxDepthNoRecursion(root, false)); 
	}
	
	// Find the minimum depth in the tree without using recursion
	private static int minDepthNoRecursion(Node root) {
		return Math.min(maxDepthNoRecursion(root, true), maxDepthNoRecursion(root, false)); 
	}
	
	private static int maxDepthNoRecursion(Node root, boolean left) {
		Stack<Node> stack = new Stack<>();
		stack.add(root);
		int depth = 0;
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			if (left && node.left != null) stack.add(node.left);
			// Add the right node only if the left node is empty to find max depth
			else if (left && node.left == null && node.right != null) stack.add(node.right); 
			else if (!left && node.right != null) stack.add(node.right);
			// Add the left node only if the right node is empty to find max depth
			else if (!left && node.right == null && node.left != null) stack.add(node.left);
			depth++;
		}
		return depth;
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
