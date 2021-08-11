package revise.terminaloperation;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDB;

public class TerminalExample3 {
	public static void main(String args[]) {
		groupByExample1();
		groupByExample2();
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
