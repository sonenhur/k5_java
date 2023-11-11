package chap14;

import java.util.Arrays;
import java.util.Comparator;

class Student {
	String sno;
	String sname;

	public Student(String sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}

	public String toString() {
		return "[" + sno + ", " + sname + "]";
	}

	public int compareTo(Student student) {
		return Integer.parseInt(this.sno) - Integer.parseInt(sno);
	}
}

public class 객체배열정렬comparator {
	static void sortStudent(Student[] data, Comparator<Student> comp) {
		Student temp;
		for (int i = 0; i < data.length;i++) 
			for (int j = i + 1; j < data.length; j++)
			{if (data[i].compareTo(data[j]) > 0) {
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}

			}
		Arrays.sort(data, comp);
	}

	public static void main(String[] args) {
//		Comparator<Student> compNo = new Comparator<Student>(){
//			@Override
//			public int compare(Student s1, Student s2) {};
		Comparator<Student> compNo = (s1, s2) -> s1.sno.compareTo(s2.sno);
//		Comparator<Student> compName = new Comparator<Student>(){
//			@Override
//			public int compare(Student s1, Student s2) {};
		Comparator<Student> compName = (s1, s2) -> s1.sname.compareTo(s2.sname);

		Student[] data = {
				new Student("9", "홍길홍"), 
				new Student("12", "홍길동"), 
				new Student("121", "홍길순"),
				new Student("213", "홍길춘")

		};

		sortStudent(data, compNo);
		// Arrays.sort(data, comp);//이게 문제가 있어서 sortStudent()를 구현
		// Collections.sort(data, comp);
		/*
		 * Arrays.sort(data, new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student s1, Student s2) {
		 * 
		 * });
		 */
		for (Student st : data)
			System.out.print(" " + st);
	}

}
