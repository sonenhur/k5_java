package chap3_searchingAlgorithm;

//3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
//comparator 구현 실습

import java.util.Arrays;
import java.util.Random;

public class _4정수배열이진탐색 {

	static void inputData(int[] data) {
		// 난수 생성 입력
		Random rand = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(70);
		}
	}

	static void showData(int[] data) {
		for (int d : data) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
	static void sortData(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i] > data[j]) {
					int temp;
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
	}
	static int linearSearch(int[] data, int key) {
		for (int i=0; i<data.length; i++)
			if (data[i]==key)
				return i;
		return -1;
//		int i = 0;
//		while (true) {
//			if (i == data.length)
//				return -1;
//			if (data[i] == key)
//				return i;
//			i++;
//		}
	}
	static int binarySearch(int[] data, int key) {
		int left = 0;
		int right = data.length - 1;
//		left와 right 변수를 사용하여 탐색할 배열의 범위를 정의한다.
//		처음에는 left는 0, right는 배열의 마지막 인덱스로 설정된다.
		do {
			int center = (left + right) / 2;
			if (data[center] == key)
				return center;
			else if (data[center] < key)
				left = center + 1;
			else
				right = center - 1;
		} while (left <= right);
		
		return -1;
	}
//		do-while 루프를 시작한다. 이 루프는 left가 right보다 작거나 같을 때까지 계속된다.
//		루프 내에서, center 변수는 현재 탐색 범위의 중간 인덱스를 나타낸다.
//		만약 center 인덱스의 값이 찾고자 하는 key와 같다면, center를 반환하고 함수를 종료한다.
//		만약 center 인덱스의 값이 key보다 작다면, left를 center + 1로 설정하여 탐색 범위를 오른쪽 반으로 줄인다.
//		만약 center 인덱스의 값이 key보다 크다면, right를 center - 1로 설정하여 탐색 범위를 왼쪽 반으로 줄인다.
//		left가 right보다 크게 되면, 즉 탐색 범위가 없어지면 루프를 종료하고 -1을 반환한다. 이는 key가 배열에 없음을 나타낸다.
	
	
	public static void main(String[] args) {
		int[] data = new int[10];
		inputData(data);
		showData(data);
		sortData(data);
		System.out.println();
		for (int num : data) {
			System.out.print(num + " ");
		}
		int key = 33;
		int result = linearSearch(data, key);
		System.out.println("\n linearSearch(): result = " + result);

		key = 39;
		result = binarySearch(data, key);
		System.out.println("\n binarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		if (idx < 0)
			System.out.println("그 값의 요소가 없습니다");
		else
			System.out.println("\n Arrays.binarySearch(): result = " + idx);
	}
}
