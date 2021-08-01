package methodreference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MethodReferenceExample8 {
	public static void main(String args[]) {
		List<String> values = new ArrayList<>();
		values.add("1");
		values.add("2");
		values.add("3");
		values.add("4");
		values.forEach((String s) -> {
			Integer value = Integer.valueOf(s);
			Consumer<Integer> consumer=System.out::println;
			consumer.accept(value);
			
		});

	}
}
