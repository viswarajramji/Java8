package revise.lambdas;

import java.util.List;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdasExamples1 {
	public static void main(String args[]) {
		example1(10);
		example2();
		example3();
	}

	public static void example3() {
		BiConsumer<String, String> biConsumer = ((x, y) -> {
			System.out.println("x : " + x + "y : " + y);
		});
		biConsumer.accept("test1", "test2");
	}

	public static void example2() {
		Consumer<String> consumer = (s -> {
			System.out.println(s);
		});

		consumer.accept("testUser");
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
