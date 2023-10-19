package chap02;

public class Test004 {

	public static void main(String[] args) {

		byte a = (byte) 0b11110100;
		System.out.println(a);

		int b = 017; // 8진법
		@SuppressWarnings("unused")
		int c = 0xf; // 16진법
		System.out.println(a + " " + b);

	}

}
