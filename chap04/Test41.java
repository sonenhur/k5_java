package chap04;

public class Test41 {

	public static void main(String[] args) {

		int[][] x = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] y = { { 1, 2 }, { 3, 4 }, { 5, 6 } };

		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < y[0].length; j++) {
				int sum = 0;
				for (int k = 0; k < y.length; k++) {
					sum += (x[i][k] * y[k][j]);
				}
				System.out.print(sum + "\t");
			}
			System.out.println("\n");
		}
	}
}
