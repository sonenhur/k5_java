package chap02;

public class Test002 {
    public static void main(String[] args) {
        // main: 프로그램의 시작
        // main 치고 ctrl + 스페이스바

        double a = 3.14f; // 실수 3.14는 기본적으로 double로 해석한다. 이는 double이 8바이트, float이 4바이트이기 때문이다.
        
        byte num1 = 1; // byte 타입의 변수 num1을 선언하고 1로 초기화한다.

        short num2 = 20; // short 타입의 변수 num2를 선언하고 20으로 초기화한다.

        long num3 = 300; // long 타입의 변수 num3을 선언하고 300으로 초기화한다.

        long depositAmount = 2147483648L; // long 타입의 변수 depositAmount를 선언하고 2147483648L로 초기화한다.
        depositAmount = 50000; // depositAmount 변수의 값을 50000으로 변경한다.
        
        boolean isMarried = true; // boolean 타입의 변수 isMarried를 선언하고 true로 초기화한다.
        
        char gender = 'F'; // char 타입의 변수 gender를 선언하고 'F'로 초기화한다.
        gender = 'M'; // gender 변수의 값을 'M'으로 변경한다.
        
        String greet = "good morning"; // String 타입의 변수 greet를 선언하고 "good morning"으로 초기화한다. String은 자바의 내장 클래스 라이브러리이다.

        System.out.println(greet + "\n" + isMarried + "\t" + gender); // greet, isMarried, gender 변수의 값을 출력한다.
    }
}
