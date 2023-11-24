package chap3_searchingAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

class PhyscData4 {
	String name;
	int height;
	double vision;

	public PhyscData4(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override
	public String toString() {
		return "<" + name + ", " + height + ", " + vision + ">";
	}
}

class HeightOrderComparator implements Comparator<PhyscData4> {
	public int compare(PhyscData4 p1, PhyscData4 p2) {
		return p1.height - p2.height;
	}
}

public class _8객체비교연산자 {

	static final Comparator<PhyscData4> HEIGHT_ORDER = new HeightOrderComparator();

	public static void main(String[] args) {
		PhyscData4[] data = {
				new PhyscData4("홍길동", 162, 0.3),
				new PhyscData4("홍동", 164, 1.3),
				new PhyscData4("홍길", 152, 0.7),
				new PhyscData4("김홍길동", 172, 0.3),
				new PhyscData4("길동", 182, 0.6),
				new PhyscData4("길동", 167, 0.2),
				new PhyscData4("길동", 167, 0.5), };
		showData(data);
		Arrays.sort(data, HEIGHT_ORDER);
		showData(data);
		PhyscData4 key = new PhyscData4("길동", 167, 0.2);
		int idx = Arrays.binarySearch(data, key, HEIGHT_ORDER);

		System.out.println("\nArrays.binarySearch(): result = " + idx);
		System.out.println("원하는 값의 위치는 " + idx +"(+1)");
	}

	static void showData(PhyscData4[] arr) {
		System.out.println();
		for (PhyscData4 d : arr) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
}
