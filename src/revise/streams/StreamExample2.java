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
	}

	public static void example4() {
		// find max of the student
		List<Student> listOfStudents = StudentDB.getAllStudents();
		Optional<Student> maxStudent = listOfStudents.stream().reduce((s1,s2)->{
			if(s1.getGpa() > s2.getGpa()) {
				return s1;
			}
			return s2;
		});
		maxStudent.ifPresent(s->{
			System.out.println(s.getName() +" "+s.getGpa() );
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
