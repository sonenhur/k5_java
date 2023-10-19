package chap02;

public class Test002 {
	public static void main(String[] args) {
		// main: 프로그램의 시작
		// main 치고 ctrl + 스페이스바

		@SuppressWarnings("unused")
		double a = 3.14f; // 코드에서 실수 3.14는 double로 해석: default로 해석
		// double은 8바이트, float는 4바이트라서 날아감
		@SuppressWarnings("unused")
		byte num1 = 1;
		@SuppressWarnings("unused")
		short num2 = 20;
		@SuppressWarnings("unused")
		long num3 = 300;
		@SuppressWarnings("unused")
		long depositAmount = 2147483648L;
		depositAmount = 50000;
		boolean isMarried = true;
		char gender = 'F';
		gender = 'M';
		String greet = "good morning"; // greet가 참조변수
		// String은 키워드가 아니라 자바에 내장된 class library

		System.out.println(greet + "\n" + isMarried + "\t" + gender);
		// System.out.println: 화면에 출력
	}

}
