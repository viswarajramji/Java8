package revise.streams;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import data.Student;
import data.StudentDB;

public class StreamExample2 {
	public static void main(String args[]) {
		example1();
		example2();
		example3();
		example4();
		example5();
		example6();
		example7();
		example8();
		example9();
		example10();
		example11();
	}

	public static void example11() {
		List<Student> studentList = StudentDB.getAllStudents();
		Optional<Student> student = studentList.stream().filter(s -> s.getGpa() == 4.0).findFirst();
		student.ifPresent(s -> {
			System.out.println("find first");
			System.out.println(s.getName());
		});
	}

	public static void example10() {
		List<Student> studentList = StudentDB.getAllStudents();
		Optional<Student> student = studentList.stream().filter(s -> s.getGpa() == 4.0).findAny();
		student.ifPresent(s -> {
			System.out.println("find anyone");
			System.out.println(s.getName());
		});
	}

	public static void example9() {
		List<Student> studentList = StudentDB.getAllStudents();
		boolean status = studentList.stream().noneMatch(s -> s.getGpa() == 4.0);
		System.out.println("noneMatch : " + status);
	}

	public static void example8() {
		List<Student> studentList = StudentDB.getAllStudents();
		boolean status = studentList.stream().anyMatch(s -> s.getGpa() == 4.0);
		System.out.println("anyMatch : " + status);
	}

	public static void example7() {
		List<Student> studentList = StudentDB.getAllStudents();
		boolean status = studentList.stream().allMatch(s -> s.getGpa() > 4.0);
		System.out.println("allMatch : " + status);
	}

	public static void example6() {
		// skip value
		int total = IntStream.rangeClosed(1, 10).skip(5).sum();
		System.out.println(total);
	}

	public static void example5() {
		// limit value
		int limit = IntStream.rangeClosed(1, 100).limit(1).sum();
		System.out.println(limit);
	}

	public static void example4() {
		// find max of the student
		List<Student> listOfStudents = StudentDB.getAllStudents();
		Optional<Student> maxStudent = listOfStudents.stream().reduce((s1, s2) -> {
			if (s1.getGpa() > s2.getGpa()) {
				return s1;
			}
			return s2;
		});
		maxStudent.ifPresent(s -> {
			System.out.println(s.getName() + " " + s.getGpa());
		});
	}

	public static void example3() {
		OptionalInt maxValue = IntStream.rangeClosed(1, 100).reduce((a, b) -> {
			if (a > b) {
				return a;
			}
			return b;
		});
		maxValue.ifPresent(System.out::println);

	}

	public static void example1() {
		int finalValue = IntStream.rangeClosed(1, 2).reduce(0, (a, b) -> {
			System.out.println("a : " + a + " b : " + b);
			return a + b;
		});
		System.out.println(finalValue);
	}

	public static void example2() {
		OptionalInt finalValue = IntStream.rangeClosed(1, 2).reduce((a, b) -> {
			System.out.println("a : " + a + " b : " + b);
			return a + b;
		});
		finalValue.ifPresent(s -> {
			System.out.println(finalValue.getAsInt());
		});
	}
}
