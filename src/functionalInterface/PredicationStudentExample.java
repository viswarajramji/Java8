package functionalInterface;

import java.util.List;
import java.util.function.Predicate;

import data.Student;
import data.StudentDB;

public class PredicationStudentExample {

	public static void main(String args[]) {

		Predicate<Student> gpaGTEFour = (Student s) -> {
			return s.getGpa() >= 4.0;
		};

		Predicate<Student> gradeTwo = (Student s) -> {
			return s.getGradeLevel()==2;
		};

		List<Student> studentList = StudentDB.getAllStudents();
		studentList.forEach((Student s) -> {
			if (gpaGTEFour.and(gradeTwo).test(s)) {
				System.out.println(s.getName());
			}
		});

	}
}
