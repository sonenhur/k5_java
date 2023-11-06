package chap05;

public class Test {
	
	public static int f(int x) {
		int value;
		value = 2 * x * x + 4 * x + 5;
		return value;}

	public static void main(String[] args) {
		int y;
		y = f(2);
		System.out.println("y = " + y);
		
		Armor arm = new Armor();
//		arm.name = "홍길동"; //name에 접근하는 곳이 다른클래스(파일)
		arm.weight = 10; //default는 같은 패키지에서 접근 가능
		arm.color = "Red";
	{
}
}
}