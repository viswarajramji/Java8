package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDB;

public class StreamMap {
	public static void main(String args[]) {
		List<Student> listStudents = StudentDB.getAllStudents();
		List<String> names = listStudents.stream().map((Student s) -> {
			return s.getName();
		}).collect(Collectors.toList());
		
		System.out.println(Arrays.toString(names.toArray()));
		
		Set<String> uniqueName = listStudents.stream().map((Student s) -> {
			return s.getName();
		}).collect(Collectors.toSet());
	}
}
