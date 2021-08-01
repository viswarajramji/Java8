package methodreference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class MyUtility {
	public static void printUpper(String value) {
		value = value.toUpperCase();
		System.out.println(value);
	}
}

public class MethodReferenceExample9 {
	public static void main(String args[]) {
		List<String> values = new ArrayList<>();
		values.add("test");
		values.add("shan");
		values.add("dude");
		values.add("text");
		// direct method reference
		System.out.println("****************");
		values.forEach(MyUtility::printUpper);
		System.out.println("****************");
		// method reference reference
		values.forEach((String s) -> {
			Consumer<String> consumer=MyUtility::printUpper;
			consumer.accept(s);
		});
		System.out.println("****************");

	}
}
