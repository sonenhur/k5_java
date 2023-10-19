package chap02;

public class Test005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte a = 0b00010001; // 2진수 표현은 0b로 시작함
		byte b = 0b00100010;
		System.out.println(a);
		System.out.println(Integer.toBinaryString(a));
		int c = a & b;
		System.out.println(Integer.toBinaryString(c));
		int d = a | b;
		System.out.println(Integer.toBinaryString(d));
		int e = a ^ b;
		System.out.println(Integer.toBinaryString(e));

		int f = 12;
		int g = ~f + 1; // ~ : 0을 1로, 1을 0으로 비트연산자
		System.out.println("g = " + g);

		int h = f << 1; // 왼쪽으로 1비트 이동 = 2배 숫자
		System.out.println("h = " + h);
	}

}
