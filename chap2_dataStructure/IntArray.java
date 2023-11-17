package chap2_dataStructure;

import java.util.Random;
import java.util.Scanner;

public class IntArray {
	static void sort(int[] a) {
		for (int i = 0; i < a.length; i++)
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp;
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
	}

	static int maxOf(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++)
			if (a[i] > max)
				max = a[i];
		return max;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		System.out.print("배열 수: ");
		int num = stdIn.nextInt();
		int[] a = new int[num];
		for (int i = 0; i < num; i++) {
			a[i] = rand.nextInt(100);
		}
		sort(a);
		for (int n : a)
			System.out.print(n + " ");
	}
}
