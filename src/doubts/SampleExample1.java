package doubts;

import java.util.function.Supplier;

class Sample {

	public static String getTest() {
		return "test";
	}
}

public class SampleExample1 {
	public static void main(String args[]) {
		Supplier<String> value=Sample::getTest;
		System.out.println(value.get());
	}
}
