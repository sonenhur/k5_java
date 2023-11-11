package chap14;

///*
// * public interface Comparator<T>{
// *    int compare(T 01, T 02);
// *    }
// *    
// * public interface Comparable<T> {
// *   public int compareTo(T o);
// *   }   
// */

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
}

public class 객체배열정렬comparator {
	static void sortStudent(Student[] data, Comparator<Student> comp) {
		Arrays.sort(data, comp);
	}

	public static void main(String[] args) {
//		Comparator<Student> compNo = new Comparator<Student>(){
//			@Override
//			public int compare(Student s1, Student s2) {};
//		Comparator<Student> compNo = (s1, s2) -> s1.sno.compareTo(s2.sno); // 람다식 변환
		Comparator<Student> compNo = (s1, s2) -> Integer.compare(Integer.parseInt(s1.sno), Integer.parseInt(s2.sno)); //인트 변환
//		Comparator<Student> compName = new Comparator<Student>(){
//			@Override
//			public int compare(Student s1, Student s2) {};
		Comparator<Student> compName = (s1, s2) -> s1.sname.compareTo(s2.sname);

		Student[] data = { new Student("9", "홍길홍"), new Student("12", "홍길동"), new Student("121", "홍길순"),
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
		sortStudent(data, compNo);
		for (Student st : data)
			System.out.print(" " + st);
	}
}
