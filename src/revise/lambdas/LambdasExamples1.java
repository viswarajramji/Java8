package revise.lambdas;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import data.Student;
import data.StudentDB;

class StringConcat {
	public static String concat(String x, String y) {
		return "Name : " + x + " Gender : " + y;
	}
}

public class LambdasExamples1 {
	public static void main(String args[]) {
		example1(10);
		example2();
		example3();
		example4();
		example5();
		example6();
		example7();
		example8();
		example9();

	}

	public static void example9() {
		System.out.println("Binary Functions");
		List<Student> listStudents = StudentDB.getAllStudents();
		BinaryOperator<String> binaryOperator = StringConcat::concat;
		listStudents.forEach(s -> {
			System.out.println(binaryOperator.apply(s.getName(), s.getGender()));
		});
	}

	public static void example8() {
		System.out.println("Unary Functions");
		List<Student> listStudents = StudentDB.getAllStudents();
		UnaryOperator<String> unaryOperator = String::toUpperCase;
		listStudents.forEach(s -> {
			System.out.println(unaryOperator.apply(s.getName()));
		});
	}

	public static void example7() {
		System.out.println("List all names");
		List<Student> listStudents = StudentDB.getAllStudents();
		Map<Integer, Optional<Student>> values = listStudents.stream().collect(
				Collectors.groupingBy(Student::getGradeLevel, Collectors.minBy(Comparator.comparing(Student::getGpa))));
		values.forEach((grade, optStudent) -> {
			System.out.println("Grade : " + grade);
			optStudent.ifPresent(s -> {
				System.out.println("Name : " + s.getName() + "GPA : " + s.getGpa());
			});
		});
	}

	public static void example6() {
		System.out.println("List all names");
		List<Student> listStudents = StudentDB.getAllStudents();
		Function<String, String> func = String::toUpperCase;
		listStudents.forEach(s -> {
			System.out.println(func.apply(s.getName()));
		});
	}

	public static void example5() {
		System.out.println("The example 5");
		Predicate<Student> filterGender = (Student s) -> "male".equals(s.getGender());
		List<Student> listStudents = StudentDB.getAllStudents();
		System.out.println("FeMale");
		listStudents.forEach(s -> {
			if (filterGender.negate().test(s)) {
				System.out.println("Name : " + s.getName() + " GPA : " + s.getGpa());
			}
		});
		System.out.println("Male");
		listStudents.forEach(s -> {
			if (filterGender.test(s)) {
				System.out.println("Name : " + s.getName() + " GPA : " + s.getGpa());
			}
		});
	}

	public static void example4() {
		Predicate<Integer> agePredicate = ((Integer i) -> {
			if (i < 18) {
				return true;
			}
			return false;
		});

		Predicate<Integer> isMale = ((Integer i) -> {
			if (i > 5) {
				return true;
			}
			return false;
		});

		System.out.println(agePredicate.and(isMale).test(10));
	}

	public static void example3() {
		BiConsumer<String, String> biConsumer1 = ((x, y) -> {
			System.out.println("x : " + x + "y : " + y);
		});

		BiConsumer<String, String> biConsumer2 = ((x, y) -> {
			System.out.println("x : " + x + "y : " + y);
		});

		biConsumer1.andThen(biConsumer2).accept("test1", "test2");
	}

	public static void example2() {
		Consumer<String> consumer1 = (s -> {
			System.out.println(s);
		});

		Consumer<String> consumer2 = (s -> {
			System.out.println(s);
		});

		consumer1.andThen(consumer2).accept("test");

	}

	public static void example1(int limit) {
		List<String> streamList = Stream.generate(UUID::randomUUID).limit(limit).map(UUID::toString)
				.collect(Collectors.toList());
		streamList.forEach((String s) -> {
			System.out.println(s);
		});

		streamList.forEach(s -> {
			System.out.println(s);
		});

		streamList.forEach(System.out::println);
	}
}
