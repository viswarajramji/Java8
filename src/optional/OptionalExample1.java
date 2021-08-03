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
		printNamesIfPresent();
		printNamesFilter();
		printflatMap();

	}

	public static void printflatMap() {
		System.out.println("**** flatmap****");
		Optional<Student> values = Optional.ofNullable(StudentDB.getAllStudents().get(1));
		values.flatMap(Student::getSubject).ifPresent((s)->{
			System.out.println(s.getName());
		});
		
	}

	public static void printNamesFilter() {
		System.out.println("*** filter **");
		// Optional<Student>
		// values=Optional.ofNullable(StudentDB.getAllStudents().get(0));
		Optional<Student> values = Optional.ofNullable(null);
		String val = values.filter(s -> s.getGpa() >= 4.0).map(Student::getName).orElse("no found");
		System.out.println(val);
	}

	public static void printNamesIfPresent() {
		Optional<Student> values = Optional.ofNullable(StudentDB.getAllStudents().get(0));
		values.ifPresent((Student s) -> {
			System.out.println("printNamesIfPresent");
			System.out.println(s.getName());
		});

	}

	public static void printNameswithOrElseThrow() {
		Optional<Student> values = Optional.ofNullable(StudentDB.getAllStudents().get(0));
		String value = values.map(Student::getName).orElseThrow(RuntimeException::new);
		System.out.println(value);

// 		Run time exception	
//		values=Optional.ofNullable(null);
//		value=values.map(Student::getName).orElseThrow(RuntimeException::new);
//		System.out.println(value);
	}

	public static void printNameswithOrElseGet() {
		Optional<Student> values = Optional.ofNullable(StudentDB.getAllStudents().get(0));
		String value = values.map(Student::getName).orElseGet(() -> "hello world");
		System.out.println(value);

		values = Optional.ofNullable(null);
		value = values.map(Student::getName).orElseGet(() -> "hello world");
		System.out.println(value);
	}

	public static void printNameswithOrElse() {
		Optional<Student> values = Optional.ofNullable(StudentDB.getAllStudents().get(0));
		String value = values.map(Student::getName).orElse("No value found");
		System.out.println(value);

		values = Optional.ofNullable(null);
		value = values.map(Student::getName).orElse("No value found");
		System.out.println(value);

	}

	public static void printNameswithOptionalOf() {
		// Optional<String> value = Optional.of(null);
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
