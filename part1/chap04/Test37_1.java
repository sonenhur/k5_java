package part1.chap04;

import java.util.Scanner;

public class Test37_1 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int[] score = new int[5];
		System.out.print("국어 점수: ");
		score[0] = sc.nextInt();

		System.out.print("영어 점수: ");
		score[1] = sc.nextInt();

		System.out.print("수학 점수: ");
		score[2] = sc.nextInt();

		System.out.print("사회 점수: ");
		score[3] = sc.nextInt();

		System.out.print("과학 점수: ");
		score[4] = sc.nextInt();

		int sum = 0; // 총점
		double avg = 0.0; // 평균
		int max = 0; // 최댓값
		int min = 999; // 최솟값

		for (int i = 0; i < score.length; i++) {
			sum += score[i];
			if (max < score[i])
				max = score[i];
			if (min > score[i])
				min = score[i];
		}

		avg = sum / score.length;
		System.out.println("총 점 : " + sum);
		System.out.println("평 균 : " + avg);
		System.out.println("최댓값 : " + max);
		System.out.println("최솟값 : " + min);
	}

}
