package chap14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student3 {
	String sno;
	String sname;
}

public class 객체리스트정렬comparator {
	public static void main(String[] args) {
		Comparator<Student3> compSno = new Comparator<Student3>() {
			@Override
			public int compare(Student3 s1, Student3 s2) {
				return s1.sno.compareTo(s2.sno);
			}
		};
		Comparator<Student3> compName = new Comparator<Student3>() {
			@Override
			public int compare(Student3 s1, Student3 s2) {
				return s1.sname.compareTo(s2.sname);
			}
		};
		ArrayList<Student3> al = new ArrayList<>();

		// Add some Student3 objects to the list
		// ...

		// Sort by sno
		Collections.sort(al, compSno);
		for (Student3 st : al)
			System.out.print(" " + st.sno);

		System.out.println();

		// Sort by sname
		Collections.sort(al, compName);
		for (Student3 st : al)
			System.out.print(" " + st.sname);
	}
}
