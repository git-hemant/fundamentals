package misc;
public class Shift {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
		shift2();
	}

	public static void shift1() {
		int i = 0;
		while (-1 << i != 0) {
			System.out.println(i + " -- -1 << " + i + " = " + (-1 << i));;
			i++;
		}

	}

	public static void shift2() {
		for (int i = -1; i != 0; ) {
			System.out.println(i);
			i = i << 1;
		}
	}
}