package methodreference;

import java.util.function.Function;

public class MethodReferenceExample2 {
	public static void main(String args[]) {
		Function<Integer, String> intToStr = (Integer i) -> {
			return String.valueOf(i);
		};
		// method reference
		Function<Integer, String> intToStrRef = String::valueOf;

		System.out.println(intToStr.apply(10));
		System.out.println(intToStrRef.apply(10));

	}
}
