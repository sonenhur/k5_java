package chap03;

public class Test010 {
	public static void main(String[] args) {
		// JAVA 반복문

//	for문
	int a = 0;
	int d = 5;
//		for (int i = 0; i < 1; i++) {
//			      ↑초기값  ↑조건식  ↑증감
//			조건식 만족 해야 한번 실행됨 (i < 0이면 안돌아감)
//			System.out.println();
//			System.out.println("a = " + a);
//			a += d;
//	while문
//		int i = 0;
//		while (i < 5) {
//			System.out.println("i = " + i + " a = " + a);
//			a += d;
//			i++;
	int i = 0;
	do {
		System.out.println("i = " + i + " a = " + a);
		a += d;
		i++;
		}while(i<5);
	}
}
