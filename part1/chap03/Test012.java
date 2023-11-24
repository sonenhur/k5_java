package part1.chap03;

public class Test012 {
	public static void main(String[] args) {
		int ix = 6;
		if (ix % 2 == 0) {
			if (ix % 3 == 0)
				System.out.println(ix + "은 2,3의 배수입니다.");
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.println(i * j);
				System.out.println();
				j++;
			}
		}
//		j++;
	}
}