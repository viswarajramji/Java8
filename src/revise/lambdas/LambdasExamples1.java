package revise.lambdas;

import java.util.List;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import data.Student;
import data.StudentDB;

public class LambdasExamples1 {
	public static void main(String args[]) {
		example1(10);
		example2();
		example3();
		example4();
		example5();

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
