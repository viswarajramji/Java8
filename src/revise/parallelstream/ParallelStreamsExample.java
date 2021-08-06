package revise.parallelstream;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamsExample {
	public static void main(String args[]) {
		performance(ParallelStreamsExample::Stream, 1000);
		performance(ParallelStreamsExample::parallelStream, 1000);
	}

	public static void performance(Supplier<Integer> supplier, int num) {
		Long start = System.currentTimeMillis();
		for (int i = 0; i < num; i++) {
			supplier.get();
		}
		Long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static Integer Stream() {
		return IntStream.rangeClosed(1, 100).sum();
	}

	public static Integer parallelStream() {
		return IntStream.rangeClosed(1, 100).sum();
	}

}
