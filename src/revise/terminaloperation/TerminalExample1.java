package revise.terminaloperation;

import java.util.Arrays;
import java.util.List;
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
	}

	public static void mapping() {
		List<Student> students = StudentDB.getAllStudents();
		String str= 
				students
				.stream()
				.collect(Collectors.mapping(Student::getName, Collectors.toSet()))
				.stream().collect(Collectors.joining(" "));
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
