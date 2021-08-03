package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
	}
	
	public static void summingInt() {
		List<Student> students=StudentDB.getAllStudents();
		int mark1Sum=students.stream().collect(Collectors.summingInt(Student::getMark1));
		System.out.println(mark1Sum);
	}
	
	
	public static void averagingInt() {
		List<Student> students=StudentDB.getAllStudents();
		Double mark1Sum=students.stream().collect(Collectors.averagingDouble(Student::getMark1));
		System.out.println(mark1Sum);
	}

	
	public static void maxBy()
	{
		System.out.println("****maxBy*****");
		List<Student> students=StudentDB.getAllStudents();
		Optional<Student> result = students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getMark1)));
		if(result.isPresent()) {
			System.out.println(result.get().getName());
		}
	}
	
	public static void minBy()
	{
		System.out.println("****minBy*****");
		List<Student> students=StudentDB.getAllStudents();
		Optional<Student> result = students.stream().collect(Collectors.minBy(Comparator.comparing(Student::getMark1)));
		if(result.isPresent()) {
			System.out.println(result.get().getName());
		}
	}
	
	
	
	public static void mapping() {
		System.out.println("****mapping*****");
		List<Student> students=StudentDB.getAllStudents();
		List<String> result=students.stream().collect(Collectors.mapping(Student::getName, Collectors.toList()));
		result.forEach(System.out::println);
	}

	public static void counting() {
		System.out.println("****Couting*****");
		List<Student> students=StudentDB.getAllStudents();
		Long count=students.stream().collect(Collectors.counting());
		System.out.println(count);
	}
	
	public static void concatStreamValues1() {
		System.out.println("****concatStreamValues1*****");
		List<Student> students=StudentDB.getAllStudents();
		String result=students.stream().map(Student::getName).collect(Collectors.joining());
		System.out.println(result);
	}
	
	public static void concatStreamValues2() {
		System.out.println("****concatStreamValues2*****");
		List<Student> students=StudentDB.getAllStudents();
		String result=students.stream().map(Student::getName).collect(Collectors.joining(","));
		System.out.println(result);
	}

	
	public static void concatStreamValues3() {
		System.out.println("****concatStreamValues3*****");
		List<Student> students=StudentDB.getAllStudents();
		String result=students.stream().map(Student::getName).collect(Collectors.joining(",","(",")"));
		System.out.println(result);
	}
}
