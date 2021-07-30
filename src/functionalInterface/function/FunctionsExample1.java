package functionalInterface.function;

import java.util.List;
import java.util.function.Function;

import data.Student;
import data.StudentDB;

public class FunctionsExample1 {
	public static void main(String args[]) {
		List<Student> students = StudentDB.getAllStudents();
		Function<Student, Student> func = (Student s) -> {
			s.setName(s.getName().toUpperCase());
			return s;
		};

		students.forEach((Student s) -> {
			func.apply(s);
			System.out.println(s.getName());
		});
	}
}
