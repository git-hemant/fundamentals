package c.ariba;

/**
 * Test the node traversal APIs.
 */
public class NodeTest
{
	public static void main(String[] args)
	{
		NodeTest nt = new NodeTest();
		// Test without cycle.
		Node root = nt.createSampleNode(false);
		int maxDepth = TraversalUtil.maxDepth(root);
		System.out.println("Testing graph without cycle:");
		System.out.println("  Max depth is: " + maxDepth);
		boolean containsCycle = TraversalUtil.containsCycle(root);
		System.out.println("  Graph contains cycle: " + containsCycle);
		
		// Test with cycle.
		System.out.println("Testing graph with cycle:");
		Node rootWithCycle = nt.createSampleNode(true);
		maxDepth = TraversalUtil.maxDepth(rootWithCycle);
		System.out.println("  Max depth is: " + maxDepth);
		containsCycle = TraversalUtil.containsCycle(rootWithCycle);
		System.out.println("  Graph (with cycle)  contains cycle: " + containsCycle);
		
	}

	/**
	 * Works on the following sample data, where E may or may not have cycle with A.
	 *      A 
	 *     / \
	 *    B   C
	 *     \ /
	 *      D
	 *      |
	 *      E
	 * @param withCycle True means node E and A are having cycle.
	 */
	public static Node createSampleNode(boolean withCycle)
	{
		Node nodeA = new Node('A');
		Node nodeB = new Node('B');
		Node nodeC = new Node('C');
		Node nodeD = new Node('D');
		Node nodeE = new Node('E');
		nodeA.addChild(nodeB);
		nodeA.addChild(nodeC);
		nodeB.addChild(nodeD);
		nodeC.addChild(nodeD);
		nodeD.addChild(nodeE);
		
		if (withCycle) {
			nodeE.addChild(nodeA);
		}
		
		return nodeA;
	}
}
