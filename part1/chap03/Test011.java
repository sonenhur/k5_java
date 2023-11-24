package part1.chap03;

public class Test011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//	for문으로 구구단 만들기
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.print(i + "*" + j + "=" + (i * j) + " ");
			}
				System.out.println();
		}
//	while문으로 구구단 만들기
		System.out.println();
		int x = 1;
		int y = 1;
		while (x < 10) {
			while (y < 10) {
				System.out.print(x + "*" + y + "=" + (x * y) + " ");
				y++;
			}
			x++;
			y = 1;
			System.out.println("");
		}
//	do ~ while문으로 구구단 만들기
		System.out.println();
		int a = 1;
		do {
			int b = 1;
			do {
				if (b>10)
					continue;
				System.out.print(a + "*" + b + "=" + (a * b)+ " " );
				b++;
			} while (b<10);
			System.out.println();
			a++;
		} while (a<10);
}
}