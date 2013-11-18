package dp;

import java.util.HashMap;
import java.util.Map;

// In DP we memoize (remember) and re-use solutions to sub-problems which help solve the main problem.
// Here we will memoize the fibonacci to solve the main problem of finding Nth element.
public class Fibonacci {

	public static void main(String[] args) {
		int n = 30;
		long time = System.currentTimeMillis();
		int f = fibWithDP(n);
		System.out.println("fibonacci DP for n=" + n + " number:" + f + " time: " + (System.currentTimeMillis() - time) + " recursion count: " + dpCounter);
		time = System.currentTimeMillis();
		f = fib(n);
		System.out.println("Naive fibonacci for n=" + n + " number:" + f + " time: " + (System.currentTimeMillis() - time) + " recursion count: " + counter);
	}
	
	// In this case we will use memoize the
	// computation, so that we don't need
	// to compute number twice like in
	// in naive approach.
	private static Map<Integer, Integer> memoize = new HashMap<Integer, Integer>();
	private static int dpCounter = 0;
	//Running time for it is O(N)
	private static int fibWithDP(int n) {
		Integer value = memoize.get(n);
		if (value != null) return value;
		int f;
		if (n == 0) f = 0;
		else if (n <= 2) f = 1;
		else f = fibWithDP(n - 1) + fibWithDP(n - 2);
		memoize.put(n, f); dpCounter++;
		return f;
	}
	
	static int counter = 0;
	// Running time for this is O(fib(N)-1) which means
	// it would exponential long time.
	private static int fib(int n) {
		if (n == 0) return 0;
		else if (n <= 2) return 1;
		else {counter++; return fib(n - 1) + fib(n - 2);} 
	}
}
