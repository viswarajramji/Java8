package revise.numericmethods;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class Value {
	int i;

	public Value(int i) {
		this.i = i;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

}

public class NumericStreamExample3 {
	public static void main(String args[]) {
		example1();
		example2();
		example3();
		example4();
		example5();
		example6();
	}

	public static void example6() {
		List<Value> val = IntStream.range(1, 5).mapToObj(Value::new).collect(Collectors.toList());
		val.forEach(v->{
			System.out.println(v.getI());
		});
	}

	public static void example5() {
		List<Integer> intList = IntStream.range(1, 5).boxed().collect(Collectors.toList());
		int sumValue = intList.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sumValue);

		List<Long> longList = LongStream.range(1, 5).boxed().collect(Collectors.toList());
		Long longValue = longList.stream().mapToLong(Long::longValue).sum();
		System.out.println(longValue);

	}

	public static void example4() {
		List<Integer> intList = IntStream.range(1, 5).boxed().collect(Collectors.toList());
		List<Long> longList = LongStream.range(1, 5).boxed().collect(Collectors.toList());
		intList.forEach(System.out::println);
		longList.forEach(System.out::println);
	}

	public static void example1() {
		Long intCnt = IntStream.range(1, 100).count();
		Long longCnt = LongStream.range(1, 100).count();
		System.out.println("total int count : " + intCnt);
		System.out.println("total long count : " + longCnt);
	}

	public static void example2() {
		IntStream intStream = IntStream.rangeClosed(1, 5);
		LongStream longStream = LongStream.rangeClosed(1, 5);
		System.out.println("Int Stream");
		intStream.forEach(System.out::println);
		System.out.println("Long Stream");
		longStream.forEach(System.out::println);
	}

	public static void example3() {
		int intsum = IntStream.rangeClosed(1, 5).sum();
		Long longSum = LongStream.rangeClosed(1, 5).sum();
		System.out.println("Int Stream sum: " + intsum);
		System.out.println("Long Stream sum: " + longSum);

		Double doubleInt = IntStream.rangeClosed(1, 5).average().getAsDouble();
		Double doubleLong = LongStream.rangeClosed(1, 5).average().getAsDouble();
		System.out.println("Int Stream average: " + doubleInt);
		System.out.println("Long Stream average: " + doubleLong);

		int minIntValue = IntStream.rangeClosed(1, 5).min().getAsInt();
		Long minLongValue = LongStream.rangeClosed(1, 5).min().getAsLong();
		System.out.println("Min Int Stream : " + minIntValue);
		System.out.println("Min Long Stream : " + minLongValue);

		int maxIntValue = IntStream.rangeClosed(1, 5).max().getAsInt();
		Long maxLongValue = LongStream.rangeClosed(1, 5).max().getAsLong();
		System.out.println("Min Int Stream : " + maxIntValue);
		System.out.println("Min Long Stream : " + maxLongValue);
	}
}
