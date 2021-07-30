package basics;

import java.util.Collections;
import java.util.List;

import data.Student;
import data.StudentDB;

public class ComparatorLambda {

	public static void main(String args[]) {
		List<Student> students = StudentDB.getAllStudents();
		Collections.sort(students, (Student s1, Student s2) -> {
			return s1.getName().compareTo(s2.getName());
		});
		System.out.println("Sorted Name");
		students.forEach((Student s)->{
			System.out.println(s.getName());
		});
	}
}
