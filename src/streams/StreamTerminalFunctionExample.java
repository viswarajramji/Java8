package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDB;

public class StreamTerminalFunctionExample {
	public static void main(String args[]) {

		concatStreamValues1();
		concatStreamValues2();
		concatStreamValues3();
		counting();
		mapping();
		maxBy();
		minBy();
		summingInt();
		averagingInt();
		groupBy();
		groupByCustomName();
		groupByMax();
		groupByMin();
		partitionBy();
		partitionByDownStream();
	}


	public static void partitionByDownStream() {
		Predicate<Student> predicate = ((Student s) -> {
			return s.getGpa() > 3.5;
		});
		List<Student> students = StudentDB.getAllStudents();
		Map<Boolean, Set<Student>> result = students.stream().collect(Collectors.partitioningBy(predicate,Collectors.toSet()));
		System.out.println(result);
	}
	
	public static void partitionBy() {
		Predicate<Student> predicate = ((Student s) -> {
			return s.getGpa() > 3.5;
		});
		List<Student> students = StudentDB.getAllStudents();
		Map<Boolean, List<Student>> result = students.stream().collect(Collectors.partitioningBy(predicate));
		System.out.println(result);
	}

	public static void groupByMin() {
		List<Student> students = StudentDB.getAllStudents();
		Map<Integer, Optional<Student>> studentList = students.stream().collect(
				Collectors.groupingBy(Student::getGradeLevel, Collectors.maxBy(Comparator.comparing(Student::getGpa))));
		System.out.println(studentList);

		Map<Integer, Student> studentValue = students.stream().collect(Collectors.groupingBy(Student::getGradeLevel,
				Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Student::getGpa)), Optional::get)));
		System.out.println(studentValue);

	}

	public static void groupByMax() {
		List<Student> students = StudentDB.getAllStudents();
		Map<Integer, Optional<Student>> studentList = students.stream().collect(
				Collectors.groupingBy(Student::getGradeLevel, Collectors.maxBy(Comparator.comparing(Student::getGpa))));
		System.out.println(studentList);

		Map<Integer, Student> studentValue = students.stream().collect(Collectors.groupingBy(Student::getGradeLevel,
				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)), Optional::get)));
		System.out.println(studentValue);

	}

	public static void groupByCustomName() {
		List<Student> students = StudentDB.getAllStudents();
		Map<String, List<Student>> map = students.stream()
				.collect(Collectors.groupingBy((s) -> s.getGpa() > 3.9 ? "OUTSTANDING" : "OK"));
		System.out.println(map.toString());
	}

	public static void groupBy() {
		List<Student> students = StudentDB.getAllStudents();
		Map<Integer, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getGradeLevel));
		System.out.println(map.toString());
	}

	public static void summingInt() {
		List<Student> students = StudentDB.getAllStudents();
		int mark1Sum = students.stream().collect(Collectors.summingInt(Student::getMark1));
		System.out.println(mark1Sum);
	}

	public static void averagingInt() {
		List<Student> students = StudentDB.getAllStudents();
		Double mark1Sum = students.stream().collect(Collectors.averagingDouble(Student::getMark1));
		System.out.println(mark1Sum);
	}

	public static void maxBy() {
		System.out.println("****maxBy*****");
		List<Student> students = StudentDB.getAllStudents();
		Optional<Student> result = students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getMark1)));
		if (result.isPresent()) {
			System.out.println(result.get().getName());
		}
	}

	public static void minBy() {
		System.out.println("****minBy*****");
		List<Student> students = StudentDB.getAllStudents();
		Optional<Student> result = students.stream().collect(Collectors.minBy(Comparator.comparing(Student::getMark1)));
		if (result.isPresent()) {
			System.out.println(result.get().getName());
		}
	}

	public static void mapping() {
		System.out.println("****mapping*****");
		List<Student> students = StudentDB.getAllStudents();
		List<String> result = students.stream().collect(Collectors.mapping(Student::getName, Collectors.toList()));
		result.forEach(System.out::println);
	}

	public static void counting() {
		System.out.println("****Couting*****");
		List<Student> students = StudentDB.getAllStudents();
		Long count = students.stream().collect(Collectors.counting());
		System.out.println(count);
	}

	public static void concatStreamValues1() {
		System.out.println("****concatStreamValues1*****");
		List<Student> students = StudentDB.getAllStudents();
		String result = students.stream().map(Student::getName).collect(Collectors.joining());
		System.out.println(result);
	}

	public static void concatStreamValues2() {
		System.out.println("****concatStreamValues2*****");
		List<Student> students = StudentDB.getAllStudents();
		String result = students.stream().map(Student::getName).collect(Collectors.joining(","));
		System.out.println(result);
	}

	public static void concatStreamValues3() {
		System.out.println("****concatStreamValues3*****");
		List<Student> students = StudentDB.getAllStudents();
		String result = students.stream().map(Student::getName).collect(Collectors.joining(",", "(", ")"));
		System.out.println(result);
	}
}
