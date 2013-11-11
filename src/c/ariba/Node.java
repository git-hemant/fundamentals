package c.ariba;

import java.util.ArrayList;
import java.util.List;

public class Node
{
	private List<Node> children;
	// The value will be character in this case.
	private Character value;
	
	public Node(Character value) {
		this.value = value;
		children = new ArrayList<Node>();
	}
	
	public Node(Object value, Node[] children) {
		//children = new ArrayList<Node>();
	}
	
	public void addChild(Node child) {
		children.add(child);
	}
	
	public List<Node> getChildren() {
		return children;
	}
	
	public Object getValue() {
		return value;
	}
	
	public String toString() {
		// Show the value of node - this can be helpful in debugging.
		return value != null ? value.toString() : "";
	}
}
