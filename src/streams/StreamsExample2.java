package streams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDB;

public class StreamsExample2 {
	public static void main(String args[]) {
		Predicate<Student> gpa = (Student s) -> s.getGpa() >= 4.0;
		List<Student> listStudents = StudentDB.getAllStudents();
		Map<String, List<String>> map = listStudents.stream().filter(gpa).collect(Collectors.toMap(Student::getName, Student::getActivity));
		System.out.println(map.toString());

	}
}
