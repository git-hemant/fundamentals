package misc;

import java.util.Stack;

public class TowerOfHanoi {

	private int numberOfTowers = 3;
	private int numberOfPlates = 4;
	private Tower[] towers = new Tower[numberOfTowers];
	private Plate[] plates = new Plate[numberOfPlates];
	
	  public static void move(int n, int startPole, int endPole) {
		    if (n== 0){
		      return; 
		    }
		    int intermediatePole = 6 - startPole - endPole;
		    move(n-1, startPole, intermediatePole);
		    System.out.println("Move " +n + " from " + startPole + " to " +endPole);
		    move(n-1, intermediatePole, endPole);
		  }
		  
		  public static void main(String[] args) {
		    move(5, 1, 3);
		  }
	
//	public static void main(String[] args) {
//		new TowerOfHanoi().solve();
//	}
	
	private void solve() {
		for (int i = 0; i < towers.length; i++) towers[i] = new Tower();
		for (int i = 0; i < plates.length; i++) plates[i] = new Plate(numberOfPlates - i);
		
		// Now start with first tower populate with all the plates
		for (int i = plates.length; i > 0;) {
			towers[0].push(plates[--i]);
		}
		printStat();
		
		while (towers[2].plateCount() == numberOfPlates) {
			for (int i = 0; i < towers.length; i++) {
				
			}
		}
	}
	
	private void printStat() {
		System.out.println("---------------------");
		System.out.println("First tower: " + towers[0]);
		System.out.println("Second tower: " + towers[1]);
		System.out.println("Third tower: " + towers[2]);
	}
	
	class Tower {
		private Stack<Plate> plates = new Stack<Plate>();
		public void push(Plate newPlate) {
			if (!plates.isEmpty()) {
				Plate topPlate = plates.peek();
				if (topPlate != null && topPlate.size() > newPlate.size()) {
					throw new RuntimeException("Invalid push request, plate of size: " + newPlate.size() + " can't be added on top of existing plate " + topPlate.size());
				}
			}
			plates.push(newPlate);
		}
		
		public Plate pop() {
			return plates.pop();
		}
		
		public Plate peek() { 
			return plates.peek();
		}
		
		public int plateCount() {
			return plates.size();
		}
		
		public String toString() { return plates.toString(); }
	}

	class Plate {
		private int size;
		
		Plate(int size) {
			this.size = size;
		}
		
		public int size() {
			return size;
		}
		
		public String toString() {
			return Integer.toString(size);
		}
	}
}
