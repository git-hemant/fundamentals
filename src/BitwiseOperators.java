public class BitwiseOperators {
	
	static void xor() {
		int random = 47 ^ 50;
		System.out.println(random);
	}
	
	public static void main(String[] args) {
		xor();
		
		int n1 = 2;
		int n2 = 103;
		System.out.println("N1: " + (n1 << 30));
		System.out.println("N2: " + (n2 << -1));
		
		System.out.println("Int max: " + Integer.MAX_VALUE);
		System.out.println("Int min: " + Integer.MIN_VALUE);
	}
}
