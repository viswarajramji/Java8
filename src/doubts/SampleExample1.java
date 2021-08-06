package doubts;

import java.util.function.Consumer;

class Sample {

	public String getTest(String name) {
		return name;
	}
}

public class SampleExample1 {
	public static void main(String args[]) {
		Consumer<Sample> value = (Sample s) -> {
			s.getTest("hello");
		};
	}
}
