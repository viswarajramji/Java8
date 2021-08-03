package optional;

import java.util.List;
import java.util.Optional;

import data.Student;
import data.StudentDB;

public class OptionalExample1 {
	public static void main(String args[]) {
		printNames();
		printNameWithOptional();
		printNameswithOptionalOf();
		printNameswithOrElse();
		printNameswithOrElseGet();
		printNameswithOrElseThrow();
		
	}
	

	public static void printNameswithOrElseThrow() {
		Optional<Student> values=Optional.ofNullable(StudentDB.getAllStudents().get(0));
		String value=values.map(Student::getName).orElseThrow(RuntimeException::new);
		System.out.println(value);
		
// 		Run time exception	
//		values=Optional.ofNullable(null);
//		value=values.map(Student::getName).orElseThrow(RuntimeException::new);
//		System.out.println(value);
	}
	
	
	public static void printNameswithOrElseGet() {
		Optional<Student> values=Optional.ofNullable(StudentDB.getAllStudents().get(0));
		String value=values.map(Student::getName).orElseGet(()->"hello world");
		System.out.println(value);
		
		values=Optional.ofNullable(null);
		value=values.map(Student::getName).orElseGet(()->"hello world");
		System.out.println(value);
	}
	
	public static void printNameswithOrElse() {
		Optional<Student> values=Optional.ofNullable(StudentDB.getAllStudents().get(0));
		String value=values.map(Student::getName).orElse("No value found");
		System.out.println(value);
		
		values=Optional.ofNullable(null);
		value=values.map(Student::getName).orElse("No value found");
		System.out.println(value);
		
	}

	public static void printNameswithOptionalOf() {
		//Optional<String> value = Optional.of(null);
		Optional<String> value = Optional.of("test");
		if (value.isPresent()) {
			System.out.println(value.get());
			return;
		}
		System.out.println("Not found");
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
