package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamNumericFunctionExamples {
	public static void main(String args[]) {
		inputStream();
		general();
		intRange();
		longRange();
		doubleRange();
		aggregate();
	}

	public static void aggregate() {

		System.out.println("****Aggregate Function*****");
		int sum = IntStream.rangeClosed(1, 50).sum();
		System.out.println(sum);

		OptionalInt maxValue = IntStream.rangeClosed(1, 50).max();
		if (maxValue.isPresent()) {
			System.out.println(maxValue.getAsInt());
		}

		OptionalInt minValue = IntStream.rangeClosed(1, 50).min();
		if (minValue.isPresent()) {
			System.out.println(minValue.getAsInt());
		}

		OptionalDouble avgValue = IntStream.rangeClosed(1, 50).average();
		if (avgValue.isPresent()) {
			System.out.println(avgValue.getAsDouble());
		}

	}

	public static void doubleRange() {
		IntStream.range(1, 4).asDoubleStream().forEach(System.out::println);
	}

	public static void longRange() {
		Long result = LongStream.range(1, 5).sum();
		System.out.println(result);

	}

	public static void intRange() {
		int result = IntStream.range(1, 5).sum();
		System.out.println(result);

	}

	public static void general() {
		int result = IntStream.rangeClosed(1, 5).sum();
		System.out.println(result);

	}

	public static void inputStream() {
		List<Integer> val = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> sum = val.stream().reduce((x, y) -> x + y);
		if (sum.isPresent()) {
			System.out.println(sum.get());
		} else {
			System.out.println("No sum value");
		}
	}
}
