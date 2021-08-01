package methodreference;

import java.util.List;
import java.util.function.Consumer;

import data.Student;
import data.StudentDB;

public class MethodReferenceExample5 {
	public static void main(String args[]) {
		List<Student> studentRecords = StudentDB.getAllStudents();
		Consumer<String> printValue = System.out::println;
		studentRecords.forEach((Student s) -> {
			printValue.accept(s.getName());
		});
	}
}
