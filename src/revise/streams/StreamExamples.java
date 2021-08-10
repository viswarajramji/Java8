package revise.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDB;

public class StreamExamples {

	public static Predicate<Student> filterbyMale = s -> "male".equals(s.getGender());

	public static Predicate<Student> filterbyFemale = s -> "female".equals(s.getGender());

	public static void main(String args[]) {
		example1();
		example2();
		example3();

	}

	public static void example3() {
		List<Student> students = StudentDB.getAllStudents();
		Double gpa = students.stream().filter(filterbyMale).collect(Collectors.summingDouble(Student::getGpa));
		System.out.println(gpa);
		
		gpa = students.stream().filter(filterbyFemale).collect(Collectors.summingDouble(Student::getGpa));
		System.out.println(gpa);
	}

	public static void example2() {
		List<Student> students = StudentDB.getAllStudents();
		Set<String> setValue = students.stream().map(Student::getName).distinct().collect(Collectors.toSet());
		setValue.forEach(System.out::println);

		Long cnt = students.stream().count();
		System.out.println("Total cnt : " + cnt);

		List<Student> sortetList = students.stream().sorted(Comparator.comparing(Student::getGpa).reversed())
				.collect(Collectors.toList());
		sortetList.forEach(s -> {
			System.out.println("Name : " + s.getName() + " GPA : " + s.getGpa());
		});
	}

	public static void example1() {
		List<Student> students = StudentDB.getAllStudents();
		List<String> names = students.stream().filter(s -> s != null).map(Student::getName)
				.collect(Collectors.toList());
		names.stream().filter(s -> s != null).forEach(System.out::println);
	}
}
