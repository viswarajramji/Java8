package methodreference;

import java.util.function.Function;

public class ConstructorReferenceExample3 {
	public static void main(String args[]) {
		Function<String,String> func=String::new;
		String str=func.apply("hello world baby");
		System.out.println(str);
	}
}
