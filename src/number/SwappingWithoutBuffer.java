package number;

public class SwappingWithoutBuffer {

	public static void main(String[] args) {

		int a = 20;
		int b = 25;
		System.out.println("a = " + a + " b = " + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a = " + a + " b = " + b);
	}
}
