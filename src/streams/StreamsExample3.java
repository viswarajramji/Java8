package streams;

import java.util.List;
import java.util.stream.Stream;

import data.Student;
import data.StudentDB;

public class StreamsExample3 {
	public static void main(String args[]) {
		List<Student> students = StudentDB.getAllStudents();
		Stream<Student> stdStream = students.stream();
		stdStream.forEach(Student::printValue);
		stdStream.forEach(Student::printValue); // this will throw error cause streams can be invoked only once.

	}
}
