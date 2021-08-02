package streams;

import java.util.List;

import data.Student;
import data.StudentDB;

//Debugging
public class StreamsExample4 {
	public static void main(String args[]) {
		List<Student> students = StudentDB.getAllStudents();
		students.stream()
		.peek(Student::printValue)
		.filter((Student s)->s.getGradeLevel()>=4.0)
		.peek(Student::printValue)
		.forEach(Student::getName);
	}
}
