package revise.terminaloperation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDB;

public class TerminalExample1 {
	public static void main(String args[]) {
		System.out.println("***joining***");
		joining();
		System.out.println("***Counting***");
		counting();
		System.out.println("***Mapping***");
		mapping();
		System.out.println("***MinBy***");
		minBy();
		System.out.println("***MaxBy***");
		MaxBy();
	}

	public static void MaxBy() {
		List<Student> students = StudentDB.getAllStudents();
		Optional<Student> value = students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getName)));
		if (value.isPresent()) {
			System.out.println(value.get().getName());
			return;
		}
		System.out.println("Not found");

	}

	public static void minBy() {
		List<Student> students = StudentDB.getAllStudents();
		Optional<Student> value = students.stream().collect(Collectors.minBy(Comparator.comparing(Student::getName)));
		if (value.isPresent()) {
			System.out.println(value.get().getName());
			return;
		}
		System.out.println("Not found");

	}

	public static void mapping() {
		List<Student> students = StudentDB.getAllStudents();
		String str = students.stream().collect(Collectors.mapping(Student::getName, Collectors.toSet())).stream()
				.collect(Collectors.joining(" "));
		System.out.println(str);

	}

	public static void counting() {
		List<String> values = Arrays.asList("1", "2", "3", "4");
		Long count = values.stream().collect(Collectors.counting());
		System.out.println(count);
	}

	public static void joining() {
		List<String> values = Arrays.asList("1", "2", "3", "4");
		String result = values.stream().collect(Collectors.joining());
		System.out.println(result);

		result = values.stream().collect(Collectors.joining(" "));
		System.out.println(result);

		result = values.stream().collect(Collectors.joining(" ", "[", "]"));
		System.out.println(result);
	}
}
