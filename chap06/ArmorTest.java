package chap06;

public class ArmorTest {

	public static void main(String[] args) {
		Armor suit1 = new Armor();
		Armor suit2 = new Armor();
		Armor suit3 = new Armor();
		
		suit1.setName("mark6");
		suit1.setHeight(180);
		
		suit2.setName("mark7");
		suit2.setHeight(170);
		
		suit3.setName("mark8");
		suit3.setHeight(190);
		
		System.out.println(suit1.getName() + " : " + suit1.getHeight());
		System.out.println(suit2.getName() + " : " + suit2.getHeight());
		System.out.println(suit3.getName() + " : " + suit3.getHeight());
	}

}
