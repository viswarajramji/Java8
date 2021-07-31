package methodreference;

import java.util.function.Function;

public class FunctionReferenceExample1 {
	public static void main(String args[]) {
		Function<String, String> func = (String s) -> {
			return s.toLowerCase();
		};
		Function<String, String> func1 = String::toLowerCase;
		System.out.println(func.apply("TEST"));
		System.out.println(func1.apply("TEST"));
	}
}
