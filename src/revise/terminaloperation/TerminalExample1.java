package revise.terminaloperation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
		System.out.println("***SummingInt***");
		SummingInt();
		System.out.println("***AverageInt***");
		averageInt();
		System.out.println("***GroupingBy***");
		groupBy();
		System.out.println("***GroupingByCustomValue***");
		groupByCustomValue();
		System.out.println("***GroupByType2***");
		GroupByType2();
		System.out.println("***GroupByMax***");
		GroupByMax();
		System.out.println("***GroupByCollectingThen***");
		GroupByCollectingThen();

	}

	
	public static void 	GroupByCollectingThen() {
		List<Student> student = StudentDB.getAllStudents();
		Map<String, Student> values = student.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)), Optional::get)));
		values.forEach((gender,stu)->{
				System.out.println("Gender : "+gender);
				System.out.println("Student Name : "+stu.getName());
		});
	}
	
	public static void GroupByMax() {
		List<Student> student = StudentDB.getAllStudents();
		Map<String,Optional<Student>> values=student.stream().collect(
				Collectors.groupingBy(
						Student::getGender,
							Collectors.maxBy(
									Comparator.comparing(Student::getGpa)
											)));
		values.forEach((gender,optStudent)->{
				System.out.println("Gender : "+gender);
				System.out.println("Student Name : "+optStudent.get().getName());
		});
	}

	public static void GroupByType2() {
		List<Student> list = StudentDB.getAllStudents();
		Map<String, Integer> value = list.stream().collect(Collectors.groupingBy((Student s) -> {
			if (s.getGender().equals("male")) {
				return "M";
			}
			return "F";
		}, Collectors.summingInt(Student::getMark1)));
		value.forEach((String gender, Integer mark1) -> {
			System.out.println("-Gender-" + gender + "-Mark-" + mark1);
		});
	}

	public static void groupByCustomValue() {
		List<Student> list = StudentDB.getAllStudents();
		Map<String, List<Student>> value = list.stream().collect(Collectors.groupingBy((Student s) -> {
			if (s.getGender().equals("male")) {
				return "M";
			}
			return "F";
		}));
		value.forEach((String gender, List<Student> students) -> {
			System.out.println("--" + gender + "--");
			students.forEach(s -> System.out.println(s.getName()));

		});
	}

	public static void groupBy() {
		List<Student> list = StudentDB.getAllStudents();
		Map<String, List<Student>> value = list.stream().collect(Collectors.groupingBy(Student::getGender));
		value.forEach((String gender, List<Student> students) -> {
			System.out.println("--" + gender + "--");
			students.forEach(s -> System.out.println(s.getName()));

		});
	}

	public static void averageInt() {
		List<Student> list = StudentDB.getAllStudents();
		Double value = list.stream().collect(Collectors.averagingInt(Student::getMark1));
		System.out.println(value);
	}

	public static void SummingInt() {
		List<Student> list = StudentDB.getAllStudents();
		Integer value = list.stream().collect(Collectors.summingInt(Student::getMark1));
		System.out.println(value);
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
