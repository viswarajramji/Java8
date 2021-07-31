package streams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDB;

public class StreamExample1 {
	public static void main(String args[]) {
		Predicate<Student> mark = (Student s) -> {
			return s.getMark1() > 90 && s.getMark2() > 40;
		};
		List<Student> studentList = StudentDB.getAllStudents();
		Map<String, List<String>> values = studentList.stream().filter(mark)
				.collect(Collectors.toMap(
							(Student s) -> {
								return s.getName();
							}, 
							(Student s) -> {
								return s.getActivity();
							}));
		System.out.println(values);
	}
}
