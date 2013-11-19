package number;

// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
public class Fibonacci {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
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
	int fibo(int n) {
		if (n < 0)
			return -1; // Error condition.
		if (n == 0) return 0;
		else if (n <= 2) return 1;
		int a = 1, b = 1;
		for (int i = 3; i <= n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		return b;
	}

	private static int showFibNumber(int n) {
		int n1 = 0;
		int n2 = 1;
		for (int i = 0; i < n; i++) {
			System.out.println("n2=" + n2 + " n1=" + n1);
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
	
	// Calculating fibonacci with recursion is exponentially costly
	// as running time is O(fib(N)) which is exponential, while
	// without recursion we can do it in O(N) which is linear.
	public static int fibonacciRecursion(int n) {
		if (n == 0) return 0;
		else if (n <= 2) return 1;
		else return (fibonacciRecursion(n - 1) + fibonacciRecursion (n - 2)); 
	}
}
