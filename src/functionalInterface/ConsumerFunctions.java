package functionalInterface;

import java.util.function.Consumer;

public class ConsumerFunctions {
	public static void main(String args[]) {
		Consumer<String> consumer = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t.toUpperCase());
			}
		};

		consumer.accept("test");

	}
}
