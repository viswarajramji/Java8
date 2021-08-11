package revise.streams;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamExample2 {
	public static void main(String args[]) {
		example1();
		example2();
	}

	public static void example1() {
		int finalValue = IntStream.rangeClosed(1, 2).reduce(0, (a, b) -> {
			System.out.println("a : " + a + " b : " + b);
			return a + b;
		});
		System.out.println(finalValue);
	}

	public static void example2() {
		OptionalInt finalValue = IntStream.rangeClosed(1, 2).reduce((a, b) -> {
			System.out.println("a : " + a + " b : " + b);
			return a + b;
		});
		finalValue.ifPresent(s -> {
			System.out.println(finalValue.getAsInt());
		});
	}
}
