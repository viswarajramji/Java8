package revise.terminaloperation;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDB;

public class TerminalExample3 {
	public static void main(String args[]) {
		groupByExample1();
		groupByExample2();
		groupByExample3();
		groupByExample4();
	}

	public static void groupByExample4() {
		List<Student> student = StudentDB.getAllStudents();
		LinkedHashMap<Integer, Map<String, List<String>>> values = student.stream().collect(Collectors.groupingBy(
				Student::getGradeLevel, LinkedHashMap::new,
				Collectors.groupingBy(Student::getGender, Collectors.mapping(Student::getName, Collectors.toList()))));
		System.out.println(values.toString());
	}

	public static void groupByExample3() {
		List<Student> student = StudentDB.getAllStudents();
		Map<String, Map<Integer, Set<String>>> stud = student.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors.groupingBy(Student::getGradeLevel,
						Collectors.mapping(Student::getName, Collectors.toSet()))));
		System.out.println(stud.toString());
	}

	public static void groupByExample2() {
		List<Student> student = StudentDB.getAllStudents();
		Map<String, List<Student>> values = student.stream().collect(Collectors.groupingBy((Student s) -> {
			if ("male".equals(s.getGender())) {
				return "MEN";
			}
			return "WOMEN";
		}));
		values.forEach((gender, listOfStudent) -> {
			System.out.println("Gender : " + gender);
			listOfStudent.stream().map(Student::getName).forEach(System.out::println);
		});
	}

	public static void groupByExample1() {
		List<Student> student = StudentDB.getAllStudents();
		Map<String, List<Student>> values = student.stream().collect(Collectors.groupingBy(Student::getGender));
		values.forEach((gender, listOfStudent) -> {
			System.out.println("Gender : " + gender);
			listOfStudent.stream().map(Student::getName).forEach(System.out::println);
		});

	}
}
