package methodreference;

import java.util.function.Predicate;
import java.util.function.Supplier;

class Person {

	public boolean isVote(Integer age) {
		return age >= 18;
	}

}

public class FunctionReferenceExample3 {
	public static void main(String args[]) {

//		Supplier<String> s = ()-> Test.getName();
//		Supplier<String> s1 = Test::getName;

//		Predicate<String> s2 = (s) -> s.isEmpty();
//		System.out.println(s2.test(""));
//
//		Predicate<String> s3 = Test::predicate;
//		System.out.println(s3.test(""));
		Person p=new Person();
		Predicate<Integer> s1= p::isVote;
		if(s1.test(18)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}

	}
}
