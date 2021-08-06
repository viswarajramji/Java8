package revise.optional;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

import data.Student;
import data.StudentDB;

public class OptionalExamples1 {
	public static void main(String args[]) throws Exception {
		basic();
		optionalBasic();
		useCase();
		map();
		of();
		orElse();
		orElseGet();
		orElseThrow();
		ifPresent();
		filter();

		Consumer<String > cons=System.out::println;
	}

	public static void filter() {
//		Function<Student,String> func=Student::getName;
//		func.apply(StudentDB.getAllStudents().get(0));
		
		Consumer<Student> val=Student::setMark3;
		Student s1=StudentDB.getAllStudents().get(0);
		val.accept(s1);
	}

	public static void ifPresent() {
		Optional<Student> value = Optional.ofNullable(StudentDB.getAllStudents().get(0));
		value.ifPresent((s) -> {
			System.out.println(s.getName());
		});
	}

	public static void orElseThrow() throws Exception {
//		Optional<String> value = Optional.ofNullable(null);
//		String values = value.orElseThrow(Exception::new);
//		System.out.println(values);

	}

	public static void orElseGet() {
		Optional<String> value = Optional.ofNullable(null);
		String values = value.orElseGet(() -> "hello world this is shan");
		System.out.println(values);

	}

	public static void orElse() {
		Optional<Student> student = Optional.ofNullable(StudentDB.getAllStudents().get(0));
		if (student.isPresent()) {
			System.out.println(student.get().getName());
		}
		Optional<String> value = Optional.ofNullable("test");
		String values = value.orElse("Default");
		System.out.println(values);

	}

	public static void of() {
		// Optional<String> value = Optional.ofNullable(null) throw execption

	}

	public static void map() {
		Optional<Student> value = Optional.ofNullable(StudentDB.getAllStudents().get(0));
		if (!value.isPresent()) {
			System.out.println("Not found");
			return;
		}

		Optional<String> val = value.map(Student::getName);
		Supplier<String> supplier = val::get;
		System.out.println(supplier.get());

	}

	public static void useCase() {
		String name = null;
		Optional<String> value = Optional.ofNullable(name);
		if (!value.isPresent()) {
			System.out.println("Not found");
			return;
		}
		System.out.println(value.get());

	}

	public static void optionalBasic() {
		String name = "test";
		Optional<String> value = Optional.ofNullable(name);
		System.out.println(value.get());
	}

	public static void basic() {
		String name = "test";
		System.out.println(name.toString());

		name = null;
		// System.out.println(name.toString()); -->null pointer exception

	}
}
