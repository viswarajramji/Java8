package revise.parallelstream;

import java.util.stream.IntStream;

public class ParallelStreamsExample {
	public static void main(String args[]) {
		basicExample();
	}

	public static void basicExample() {
		int sumValue = IntStream.rangeClosed(1, 100).sum();
		System.out.println(sumValue);

		sumValue = IntStream.rangeClosed(1, 100).parallel().sum();
		System.out.println(sumValue);
	}
}
