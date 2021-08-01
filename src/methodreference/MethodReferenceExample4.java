package methodreference;

import java.util.List;
import java.util.function.Function;

import data.Student;
import data.StudentDB;

//static reference
public class MethodReferenceExample4 {
	public static void main(String args[]) {
		List<Student> studentRecords = StudentDB.getAllStudents();
		Function<Integer, String> func = String::valueOf;
		studentRecords.forEach((Student s) -> {
			String value = func.apply(s.getMark1());
			if (value instanceof String) {
				System.out.println(value);
			}
		});
	}
}
