package functionalInterface.supplier;

import java.util.List;
import java.util.function.Supplier;

import data.Student;
import data.StudentDB;

public class supplierExample1 {

	public static void main(String args[]) {
		Supplier<List<Student>> supplier = () -> {
			return StudentDB.getAllStudents();
		};

		supplier.get().forEach((Student s) -> {	
			System.out.println(s.getName());
		});

	}
}
