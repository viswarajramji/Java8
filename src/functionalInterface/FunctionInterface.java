package functionalInterface;

import java.util.function.Function;

public class FunctionInterface {
	public static void main(String args[]) {
		Function<String, String> uFunction=(String s)->{
			return s.toUpperCase();
		};
		
		Function<String, String> sFunction=(String s)->{
			return s.toUpperCase() +" __ "+s.toLowerCase();
		};
		System.out.println(uFunction.andThen(sFunction).apply("hello"));		
	}
}
