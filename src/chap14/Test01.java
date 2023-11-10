package chap14;

interface MyInterface {
	public void print();
}

class MyClass1 implements MyInterface {
	@Override
	public void print() {
		System.out.println("MyClass1의 객체");
	}
}

class MyClass2 implements MyInterface {
	@Override
	public void print() {
		System.out.println("MyClass2의 객체");
	}
}

public class Test01 {

	public static void main(String[] args) {
		// 방법1 : implements 키워드로 클래스 선언
		MyClass1 mc1 = new MyClass1();
		MyClass2 mc2 = new MyClass2();
		mc1.print();
		mc2.print();

		// 방법2 : 익명클래스 사용
		MyInterface mi = new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명클래스 사용");
			}
		};
		mi.print();
		
	}
}
