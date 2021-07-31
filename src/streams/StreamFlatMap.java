package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDB;

public class StreamFlatMap {
	public static void main(String args[]) {
		List<Student> listStudents = StudentDB.getAllStudents();
		List<String> activity = listStudents.stream().map((Student s) -> {
			return s.getActivity();
		}).flatMap(List::stream).collect(Collectors.toList());
		System.out.println(Arrays.toString(activity.toArray()));
	}
}
