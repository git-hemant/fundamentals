package books.cci.ch3;

import java.util.Stack;

public class P4_TowerOfHanoi {

	public static void main(String[] args) {
		int n = 5;
		Tower[] towers = new Tower[3];
		// Initialize the tower
		for (int i = 0; i < towers.length; i++)
			towers[i] = new Tower(i);
		
		// Now add all the disks in first tower.
		for (int i = n - 1; i >= 0; i--)
			towers[0].add(i);
		
		printAll(towers);		
		
		// Recursively move disk
		towers[0].moveDisks(n, towers[2], towers[1]);

		printAll(towers);		
	}
	
	private static void printAll(Tower[] towers) {
		for (Tower tower : towers) {
			System.out.println("Tower: " + (tower.index + 1) + " disks: " + tower.disks);
		}
	}

	static class Tower {
		private Stack<Integer> disks;
		private int index;

		public Tower(int i) {
			disks = new Stack<Integer>();
			index = i;
		}

		public int index() {
			return index;
		}

		public void add(int d) {
			if (!disks.isEmpty() && disks.peek() <= d) {
				System.out.println("Error placing disk " + d);
			} else {
				disks.push(d);
			}
		}

		public void moveTopTo(Tower t) {
			int top = disks.pop();
			t.add(top);
			System.out.println("Move disk " + top + " from " + index() + " to "
					+ t.index());
		}

		public void print() {
			System.out.println("Contents of Tower " + index());
			for (int i = disks.size() - 1; i >= 0; i--) {
				System.out.println(" " + disks.get(i));
			}
		}

		public void moveDisks(int n, Tower destination, Tower buffer) {
			if (n > 0) {
				moveDisks(n - 1, buffer, destination);
				moveTopTo(destination);
				buffer.moveDisks(n - 1, destination, this);
			}
		}
	}
}
