package methodreference;

import java.util.function.Predicate;
import java.util.function.Supplier;

class Test{
	public static String  getName() {
		return "UserName";
	}
	
	public static boolean predicate(String s) {
		return s.isEmpty();
	}
}


public class FunctionReferenceExample3 {
	public static void main(String args[]) {
	
//		Supplier<String> s = ()-> Test.getName();
//		Supplier<String> s1 = Test::getName;
		
		Predicate<String> s2 = (s)-> s.isEmpty();
		System.out.println(s2.test(""));
		
		
		Predicate<String> s3 = Test::predicate;
		System.out.println(s3.test(""));
		
	}
}
