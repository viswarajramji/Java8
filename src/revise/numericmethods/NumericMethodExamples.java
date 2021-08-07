package revise.numericmethods;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericMethodExamples {
	public static void main(String args[]) {
		System.out.println("*****Basic1****");
		basic1();
		System.out.println("*****Basic2****");
		basic2();
		System.out.println("*****Basic3****");
		basic3();
		System.out.println("*****Basic4****");
		basic4();
		System.out.println("*****Basic5****");
		basic5();
		System.out.println("*****Basic6****");
		basic6();

	}

	public static void basic6() {
		Long sumValue = LongStream.rangeClosed(1, 100).sum();
		System.out.println("Sum Value : " + sumValue);

		OptionalLong longValue = LongStream.rangeClosed(1, 100).min();
		if (longValue.isPresent()) {
			System.out.println("min value : " + longValue.getAsLong());
		}

		longValue = LongStream.rangeClosed(1, 100).max();
		if (longValue.isPresent()) {
			System.out.println("max value : " + longValue.getAsLong());
		}

		OptionalDouble value = LongStream.rangeClosed(1, 100).average();
		if (value.isPresent()) {
			System.out.println("max value : " + value.getAsDouble());
		}

	}

	public static void basic5() {
		int sumValue = IntStream.range(1, 100).sum();
		System.out.println("Sum Value : " + sumValue);

		OptionalInt intValue = IntStream.range(1, 100).min();
		if (intValue.isPresent()) {
			System.out.println("min value : " + intValue.getAsInt());
		}

		intValue = IntStream.rangeClosed(1, 100).max();
		if (intValue.isPresent()) {
			System.out.println("max value : " + intValue.getAsInt());
		}

		OptionalDouble val = IntStream.rangeClosed(1, 10).average();
		if (val.isPresent()) {
			System.out.println("max value : " + val.getAsDouble());
		}

	}

	public static void basic4() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 1000);
		list.forEach(System.out::println);
	}

	public static void basic3() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 1000);
		System.out.println("No of values :" + list.stream().count());
	}

	public static void basic1() {
		int total = IntStream.rangeClosed(1, 100).sum();
		System.out.println("sum value is : " + total);
	}

	public static void basic2() {
		int total = IntStream.range(1, 100).sum();
		System.out.println("sum value is : " + total);
	}
}
