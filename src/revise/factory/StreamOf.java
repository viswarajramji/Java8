package revise.factory;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOf {
	public static void main(String args[]) {
		streamOfExample();
		streamIteratorExample();
		streamGenerateExample();
		streamCollectUUIDValues(100).forEach(System.out::println);
	}

	public static List<String> streamCollectUUIDValues(int numberOfUUIDs) {
		System.out.println("collecting n values");
		return Stream.generate(UUID::randomUUID).limit(numberOfUUIDs).collect(Collectors.mapping(UUID::toString, Collectors.toList()));
	}

	public static void streamGenerateExample() {
		Stream.generate(() -> {
			return UUID.randomUUID().toString();
		}).limit(5).forEach(System.out::println);
	}

	public static void streamIteratorExample() {
		Stream.iterate(0, x -> x + 2).limit(2).forEach(System.out::println);
	}

	public static void streamOfExample() {
		Stream<String> valueList = Stream.of("a", "b", "c");
		List<String> values = valueList.collect(Collectors.toList());
		System.out.println("Example of stream of:");
		values.forEach(System.out::println);
	}
}
