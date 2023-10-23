package chap05;

public class Test40_2 {
	private static int sum(int a, int b) {
		int result = a + b;
		return result;
	}

	private static int sum(int a, int b, int c) {
		int result = a + b + c;
		return result;
	}

	public static void main(String[] args) {

		int res = sum(10, 20);
		System.out.println("sum1: " + res);
		res = sum(10, 20, 30);
		// int 또 선언하면 에러뜸
		System.out.println("sum2: " + res);
	}

}
