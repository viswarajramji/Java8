package streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDB;

public class StreamsExample1 {
	public static void main(String args[]) {
		List<Student> listStudents = StudentDB.getAllStudents();
		Map<String, List<String>> map = listStudents.stream()
				.collect(Collectors.toMap(Student::getName, Student::getActivity));
		System.out.println(map.toString());
	}
}
