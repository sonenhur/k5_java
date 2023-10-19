package chap03;

public class Test008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 970;
		int bonus;
		if (score < 100) {
			bonus = 10;
		} else if (score < 200) {
			bonus = 20;
		} else
			bonus = 30;
		System.out.println(score + bonus);
	}

}
