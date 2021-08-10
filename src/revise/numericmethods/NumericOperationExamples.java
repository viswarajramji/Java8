package revise.numericmethods;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericOperationExamples {
	public static void main(String args[]) {
		example1();
		example2();
		example3();
	}

	public static void example3() {
		int totalSum = IntStream.rangeClosed(1, 10).boxed().mapToInt(Integer::intValue).sum();
		System.out.println("totalSum :" + totalSum);
	}

	public static void example2() {
		List<Integer> iList = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
		iList.forEach(System.out::println);
	}

	public static void example1() {
		IntStream.rangeClosed(1, 10).forEach(System.out::println);
		IntStream.range(1, 10).forEach(System.out::println);
		Long count = IntStream.range(1, 100).count();
		System.out.println("count : " + count);
		int sum = IntStream.range(1, 10).sum();
		System.out.println("sum : " + sum);
		double avg = IntStream.range(1, 10).average().getAsDouble();
		System.out.println("aver: " + avg);
		OptionalInt optionalInt = IntStream.range(1, 10).min();
		System.out.println(optionalInt.getAsInt());
		optionalInt = IntStream.range(1, 10).max();
		System.out.println(optionalInt.getAsInt());

	}
}
