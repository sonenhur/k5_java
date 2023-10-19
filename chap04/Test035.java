package chap04;

import java.util.Scanner;

public class Test035 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];

		System.out.print("국어 점수:");
		arr[0] = sc.nextInt();

		System.out.print("영어 점수:");
		arr[1] = sc.nextInt();

		System.out.print("수학 점수:");
		arr[2] = sc.nextInt();

		for (int i = 0; i < 3; i++) {
			System.out.println(arr[i]);
		}
		int avg = (arr[0] + arr[1] + arr[2]) / 3;
		System.out.println("평균은 " + avg);
//		new int[5]; (
//		int[] arr = new int[5];
//		arr[0] = 10;
//		arr[1] = 20;
//		arr[2] = 30;
//		arr[3] = 40;
//		arr[4] = 50;
//		System.out.println("-".repeat(20));
//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
//		System.out.println(arr[3]);
//		System.out.println(arr[4]);
//		for문
//			for (int i = 0; i < 1; i++) {
//				      ↑초기값  ↑조건식  ↑증감
//				조건식 만족 해야 한번 실행됨
//				System.out.println();
//			
//		}
		
//		int[] arr = { 10, 20, 30, 40, 50 };
//		
//		for (int i = 0; i < 5; i++) {
//			System.out.println(arr[i]);
//			
//		System.out.println("확장된 for문");
//		for (int j : arr) {
//			System.out.println(j);
//		}
	}
}
//}