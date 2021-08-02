package methodreference;

import java.util.function.Function;

import data.Student;

public class ConstructorReferenceExample2 {
	public static void main(String args[]) {
		Function<String,Student> func=Student::new;
		Student s=func.apply("test");
		System.out.println(s.printName());
	}
}
