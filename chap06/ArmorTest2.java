package chap06;

public class ArmorTest2 {
	public void doWork() {
		Armor suit1 = new Armor();
		Armor suit2 = new Armor();
		Armor suit3 = new Armor();

		suit1.setName("d");
		suit1.setHeight(22);

		suit2.setName("s");
		suit2.setHeight(11);

		suit3.setName("J");
		suit3.setHeight(33);

		System.out.println(suit1.getName() + " : " + suit1.getHeight());
		System.out.println(suit2.getName() + " : " + suit2.getHeight());
		System.out.println(suit3.getName() + " : " + suit3.getHeight());
	}

	public static void main(String[] args) {

		ArmorTest2 at = new ArmorTest2();
		at.doWork();
		// 왜 static 달아야 하는지 안보고 쓰면서 설명할 수 있도록 연습
		// 클래스 필드 = 프로그램 시작시
	}

}