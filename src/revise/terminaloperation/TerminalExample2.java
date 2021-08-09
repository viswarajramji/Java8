package revise.terminaloperation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDB;

public class TerminalExample2 {
	public static void main(String args[]) {
		System.out.println("Joining method");
		joining();
		System.out.println("Counting method");
		counting();
		System.out.println("mapping method");
		mapping();
		System.out.println("max method");
		max();
		System.out.println("min method");
		min();
		System.out.println("sum method");
		sum();
		System.out.println("avg method");
		avg();
		System.out.println("groupingBy method");
		groupingBy();
		System.out.println("groupingByDownStream method");
		groupingDownStreamBased();
	}

	public static void groupingDownStreamBased() {
		List<Student> students = StudentDB.getAllStudents();
		Map<String, Set<Student>> value = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.toSet()));
		value.forEach((gender, StudentList) -> {
			System.out.println("Gender : " + gender);
			StudentList.forEach(student -> {
				System.out.println(student.getName());
			});
		});
	}

	public static void groupingBy() {
		List<Student> students = StudentDB.getAllStudents();
		Map<String, List<Student>> mapValues = students.stream().collect(Collectors.groupingBy(Student::getGender));
		mapValues.forEach((gender, StudentList) -> {
			System.out.println("Gender : " + gender);
			StudentList.forEach(student -> {
				System.out.println(student.getName());
			});
		});
	}

	public static void avg() {
		List<Student> students = StudentDB.getAllStudents();
		double sumValue = students.stream().collect(Collectors.averagingInt(Student::getMark1));
		System.out.println("average value : " + sumValue);
	}

	public static void sum() {
		List<Student> students = StudentDB.getAllStudents();
		int sumValue = students.stream().collect(Collectors.summingInt(Student::getMark1));
		System.out.println("sum value : " + sumValue);
	}

	public static void min() {
		List<Student> students = StudentDB.getAllStudents();
		Optional<Integer> maxValue = students.stream().map(Student::getMark1)
				.collect(Collectors.minBy(Comparator.naturalOrder()));
		if (maxValue.isPresent()) {
			System.out.println(maxValue.get());
			return;
		}
		System.out.println("Not found");
	}

	public static void max() {
		List<Student> students = StudentDB.getAllStudents();
		Optional<Student> student = students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getName)));
		if (student.isPresent()) {
			System.out.println(student.get());
			return;
		}
		System.out.println("No Student Present");
	}

	public static void mapping() {
		List<Student> students = StudentDB.getAllStudents();
		List<String> names = students.stream().collect(Collectors.mapping(Student::getName, Collectors.toList()));
		names.forEach(System.out::println);
	}

	public static void counting() {
		List<String> values = Arrays.asList("1", "2", "3", "4");
		Long cnt = values.stream().collect(Collectors.counting());
		System.out.println(cnt);
	}

	public static void joining() {
		List<String> values = Arrays.asList("1", "2", "3", "4");
		String join = values.stream().collect(Collectors.joining());
		System.out.println(join);

		String joiningDelimiter = values.stream().collect(Collectors.joining("-"));
		System.out.println(joiningDelimiter);

		String joiningPre = values.stream().collect(Collectors.joining("-", "(", ")"));
		System.out.println(joiningPre);
	}
}
