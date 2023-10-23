package chap05;

// 클래스를 기술
public class Armor {
//↑접근제한자
	// 필드
	private String name;
	//↑접근제한자
	@SuppressWarnings("unused")
	private int height;
	int weight;
	public String color;
	protected boolean isFly;

	// 메소드
	void takeOff() {
		System.out.println(name); //name에 접근하는 곳
	}
	void land() {}
	void shootLaser() {}
	void launchMissile() {}
	// ()괄호 치면 함수로 인식, {}블럭 내의 내용이 본체

	}
