package number;

public class Fibonacci {
	public static void main(String[] args) {
		for (int i = 0; i < 40; i++) {
			int standard = showFibNumber(i);
			int formula = getFibonacciUsingFormula(i);
			System.out.println("Stadard series: " + standard + " Using formula: " + formula);
			if (standard != formula) {
				System.out.println("--------------- ERROR: " + standard + " is not same as " + formula);
			}
		}
	}
	
	// It will print correct number like:
	// 0 1 1 2 3 5 8 13 21 34 ...
	private static int showFibNumber(int n) {
		int n1 = 0;
		int n2 = 1;
		for (int i = 0; i < n; i++) {
			//System.out.print(n1 + "\t");
			n2 = n1 + n2;
			n1 = n2 - n1;
		}
		return n1;
	}	
	
	public static int getFibonacciUsingFormula(int n) {
	    double f1 = Math.pow(((1 + Math.sqrt(5)) / 2.0), n);
	    double f2 = Math.pow(((1 - Math.sqrt(5)) / 2.0), n);
	    return (int) Math.floor((f1 - f2) / Math.sqrt(5));
	}	
}
