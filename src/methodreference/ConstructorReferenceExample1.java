package methodreference;

import java.util.function.Supplier;

import data.Student;

public class ConstructorReferenceExample1 {

	public static void main(String args[]) {
		Supplier<Student> supplier=Student::new;
		supplier.get().printValue();
	}
}
