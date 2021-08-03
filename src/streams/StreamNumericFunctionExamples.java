package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class StreamNumericFunctionExamples {
	public static void main(String args[]) {
		inputStream();
		general();
		
	}
	
	public static void general() {
		int result=IntStream.rangeClosed(1, 5).sum();
		System.out.println(result);
	
	}

	public static void inputStream() {
		List<Integer> val = Arrays.asList(1, 2, 3, 4,5);
		Optional<Integer> sum = val.stream().reduce((x, y) -> x + y);
		if (sum.isPresent()) {
			System.out.println(sum.get());
		} else {
			System.out.println("No sum value");
		}
	}
}
