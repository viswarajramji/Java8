package methodreference;

import java.util.List;

import data.Student;
import data.StudentDB;

public class MethodReferenceExample10 {
	public static void main(String args[]) {
		List<Student> studentRecords = StudentDB.getAllStudents();
		studentRecords.forEach(Student::printValue);
	}
}
