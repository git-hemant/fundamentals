package c.ariba;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TraversalUtil
{
	// The flag used to track whether we are showing debug messages or not.
	private static boolean DEBUG = false;
	
	private TraversalUtil() {
		// Initialization is not allowed.
	}
	
	/**
	 * Uses DFS implementation to find the maximum depth in the graph. 
	 * 
	 * Runtime complexity is O(N). 
	 * 
	 * In-case the given node contains the cycle, this function will ignore
	 * the children from where the cycle is started, so it can be safely used
	 * on the graph's with cycle.
	 * 
	 * @param rootNode The node reference from where we need to start finding the maximum depth.
	 * 
	 * @return The maximum depth between given node and any of it's ancestor.
	 */
	public static int maxDepth(final Node rootNode) {
		validateInput(rootNode);
		// We will keep the track of max depth in this variable. 
		int maxDepth = -1;
		Stack<Node> stack = new Stack<Node>();
		Map<Node, Boolean> visitedNodes = new HashMap<Node, Boolean>();
		stack.push(rootNode);
		while (!stack.isEmpty()) {
			Node currentNode = stack.peek();
			visitedNodes.put(currentNode, Boolean.TRUE);
			// check if we are at max depth.
			if (stack.size() > maxDepth) {
				maxDepth = stack.size();
			}
			List<Node> children = currentNode.getChildren();
			boolean allChildrenVisited = true;
			// Find the first children which is not visited yet.
			for (Node c : children) {
				if (visitedNodes.get(c) == null) {
					// We will never keep the two node in the stack which are at same level.
					stack.add(c);
					allChildrenVisited = false;
					// We will put only one children at a time on the stack.
					break;
				}
			}
			
			if (allChildrenVisited) {
				stack.pop();
			}
		}
		// we are reducing one from maxDepth as in the above algorithm
		// we were counting root node as well in the stack.
		return maxDepth - 1;
	}
	
	/**
	 * This function can be used to identify if the given node contains cycle.
	 * 
	 * Runtime complexity is O(N).
	 * 
	 * @param rootNode The node reference from where we need to start looking for the cycle.
	 * 
	 * @return True if the given node contains cycle, else it returns false.
	 */
	public static boolean containsCycle(final Node rootNode) {
		validateInput(rootNode);
		Stack<Node> stack = new Stack<Node>();
		stack.push(rootNode);
		while (!stack.isEmpty()) {
			Node currentNode = stack.pop();
			List<Node> children = currentNode.getChildren();
			for (Node child : children) {
				// If we ever see the root node again, then graph have cycle.
				if (child == rootNode) {
					if (DEBUG)
						System.out.println("Cycle is detected between " + currentNode + " and " + child);
					return true;
				}
				stack.push(child);
			}
		}
		return false;
	}
	
	private static void validateInput(Node node)
	{
		if (node == null) {
			throw new IllegalArgumentException("Node reference can't be null.");
		}
	}
}
