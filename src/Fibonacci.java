
public class Fibonacci {
	public static void main(String[] args) {
		int n1 = 0;
		int n2 = 1;
		for (int i = 0; i < 100; i++) {
			int fibonacciNumber = n1 + n2;
			System.out.print(i+1 + " : ");
			System.out.print(fibonacciNumber);
			System.out.println(' ');
			n1 = n2;
			n2 = fibonacciNumber;
		}
	}
}
