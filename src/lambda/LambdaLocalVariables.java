package lambda;

import java.util.function.Consumer;

//Note
public class LambdaLocalVariables {

	public static void main(String args[]) {
		int value = 0;
		Consumer<String> consumer = ((String s) -> {
			System.out.println(value);
			//value++; error as this variables are read only and cannot be modified
		});
	}
}
