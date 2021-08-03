package optional;

import java.util.List;
import java.util.Optional;

import data.Student;
import data.StudentDB;

public class OptionalExample1 {
	public static void main(String args[]) {
		printNames();
		printNameWithOptional();
	}

	public static void printNameWithOptional() {
		Optional<String> value = getNameOptionanl();
		if (value.isPresent()) {
			System.out.println(value.get());
			return;
		}
		System.out.println("No value found");

	}

	public static Optional<String> getNameOptionanl() {
		Optional<Student> student = Optional.ofNullable(StudentDB.getAllStudents().get(0));
		if (student.isPresent()) {
			return student.map(Student::getName);
		}
		return Optional.empty();
	}

	public static void printNames() {
		String name = getName();
		if (name != null) {
			System.out.println("this user name is : " + name);
			return;
		}
		System.out.println("user not found");
	}

	public static String getName() {
		List<Student> students = StudentDB.getAllStudents();
		Student student = students.get(0);
		if (students != null) {
			return student.getName();
		}
		return null;
	}
}
