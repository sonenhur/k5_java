package chap13;

import java.util.Arrays;

// Student 클래스를 정의합니다. 이 클래스는 Comparable 인터페이스를 구현합니다.
class Student implements Comparable<Student> {
	String sno;  // 학생 번호
	String sname;  // 학생 이름

	// Student 클래스의 생성자입니다. 학생 번호와 이름을 매개변수로 받습니다.
	public Student(String sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}

	// Student 객체를 문자열로 변환하는 메소드입니다.
	@Override
	public String toString() {
		return "(" + sno + "," + sname + ")";
	}

	// 두 Student 객체를 비교하는 메소드입니다.
	@Override
	public int compareTo(Student s) {
		return Integer.parseInt(this.sno) - Integer.parseInt(s.sno);
	}
}

public class 객체배열정렬 {
	// Student 객체 배열을 정렬하는 메소드입니다.
	static void sortStudent(Student[] data) {
		Student temp; //임시변수(지역변수)
		for (int i = 0; i < data.length; i++)
			for (int j = i + 1; j < data.length; j++) {
				// 두 Student 객체를 비교하여 순서를 바꿉니다.
				if (data[i].compareTo(data[j]) > 0) {
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;

				}
			}
	}

	public static void main(String[] args) {
		// Student 객체 배열을 생성하고 초기화합니다.
		Student[] data = {
				new Student("12", "홍길동"),
				new Student("121", "홍길순"),
				new Student("213", "홍길춘"),
				new Student("9", "홍길홍")
				};
		// Student 객체 배열을 정렬합니다.
		sortStudent(data);
//		Arrays.sort(data);// 이게 문제가 있어서 sortStudent()를 구현
		
		// 정렬된 Student 객체 배열을 출력합니다.
		for (Student st : data)
			// B에서 차례대로 객체를 꺼내서 A에 넣겠다는 뜻
			// B에 더이상 꺼낼 객체가 없을 때까지
			System.out.print(" " + st);
	}
}
