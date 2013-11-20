package puzzle;

public class GoldCoinGame {
	public static void main(String[] args) {

		System.out.println();
		int coins[] = new int[] { 100, 1, 20, 30, 40, 10, 20, 30, 90 };
		for (int i = 0; i < coins.length; i++)
			System.out.print(coins[i] + " , ");
		System.out.println();
		playGame(coins);
		System.out.println("Recursive call result: : "
				+ max_coin(coins, 0, coins.length - 1));

	}

	public static void playGame(int array[]) {
		// taking the first one.
		int sum = array[0];
		int sumB = 0;
		int i = 1;
		int j = array.length - 1;
		String paths = "" + array[0] + " + ";
		String pathsB = "";
		while (i < j) {

			// Time for Player B
			if (array[i] > array[j]) {
				pathsB += array[i] + " + ";
				sumB += array[i];
				i++;
			} else {
				pathsB += array[j] + " + ";
				sumB += array[j];
				j--;
			}
			// Time for player A
			if (i > j)
				break;

			if (array[i] > array[j]) {
				paths += "" + array[i] + " + ";
				sum += array[i];
				i++;
			} else {

				paths += "" + array[j] + " + ";
				sum += array[j];
				j--;
			}
		}
		System.out.println("Taking the first one:");
		if (sumB > sum) {
			System.out.println("B WINS ");
		} else {
			System.out.println("A WINS ");
		}
		System.out.println("PLAYER A " + paths + " = " + sum);
		System.out.println("PLAYER B " + pathsB + " = " + sumB);
		// Start by taking the last one
		sum = array[array.length - 1];
		i = 0;
		j = array.length - 2;
		paths = "" + array[array.length - 1] + " + ";
		while (i < j) {
			// Time for Player B
			if (array[i] > array[j]) {
				pathsB += array[i] + " + ";
				sumB += array[i];
				i++;
			} else {
				pathsB += array[j] + " + ";
				sumB += array[j];
				j--;

			}
			// Time for player A
			if (i > j)
				break;

			if (array[i] > array[j]) {
				paths += "" + array[i] + " + ";
				sum += array[i];
				i++;
			} else {

				paths += "" + array[j] + " + ";
				sum += array[j];
				j--;
			}
		}
		System.out.println("Taking the Last one:");
		if (sumB > sum) {
			System.out.println("B WINS");
		} else {
			System.out.println("A WINS");
		}
		System.out.println("PLAYER A " + paths + " = " + sum);
		System.out.println("PLAYER B " + pathsB + " = " + sumB);

	}

	public static int max_coin(int coin[], int start, int end) {
		if (start > end)
			return 0;

		int a = coin[start]
				+ Math.min(max_coin(coin, start + 2, end),
						max_coin(coin, start + 1, end - 1));
		int b = coin[end]
				+ Math.min(max_coin(coin, start + 1, end - 1),
						max_coin(coin, start, end - 2));

		return Math.max(a, b);
	}
}
