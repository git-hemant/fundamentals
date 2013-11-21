package books.cci.ch4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

// Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
public class P2_GraphFindRouteBetweenNodes {

	/**
	 *  N1 --> N2
	 *  ^      |
	 *  |      v
	 *  N4<--  N3
	 * 
	 */
	public static void main(String[] args) {
		Node n1 = new Node("N1");
		Node n2 = new Node("N2");
		Node n3 = new Node("N3");
		Node n4 = new Node("N4");
		
		n1.addAdjacent(n2);
		n1.addAdjacent(n4);
		
		n2.addAdjacent(n1);
		n2.addAdjacent(n3);
		
		n3.addAdjacent(n2);
		n3.addAdjacent(n4);
		
		n4.addAdjacent(n3);
		n4.addAdjacent(n1);
		
		Graph g = new Graph();
		g.nodes = new Node[] {n1, n2, n3, n4};
		
		boolean n1ToN4 = search(g, n1, n4);
		System.out.println("Path from n1 to n4 exist: " + n1ToN4);
	}
	
	public static boolean search(Graph g, Node start, Node end) {
		LinkedList<Node> q = new LinkedList<Node>(); // operates as Stack
		for (Node u : g.getNodes()) {
			u.state = State.Unvisited;
		}
		start.state = State.Visiting;
		q.add(start);
		Node u;
		while (!q.isEmpty()) {
			u = q.removeFirst(); // i.e., pop()
			if (u != null) {
				for (Node v : u.getAdjacent()) {
					if (v.state == State.Unvisited) {
						if (v == end) {
							return true;
						} else {
							v.state = State.Visiting;
							q.add(v);
						}
					}
				}
				u.state = State.Visited;
			}
		}
		return false;
	}

	// Graph class
	static class Graph {
		Node[] nodes;
		Node[] getNodes() {
			return nodes;
		}
	}

	// Node class
	static class Node {
		Collection<Node> adjacent = new ArrayList<Node>();
		State state;
		Object data;
		Node(Object data) { this.data = data; }

		void addAdjacent(Node n) {
			adjacent.add(n);
		}

		Collection<Node> getAdjacent() {
			return adjacent;
		}

	}
	public enum State {
		Unvisited, Visited, Visiting;
	}

}
