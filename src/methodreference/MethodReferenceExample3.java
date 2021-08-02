package methodreference;

import java.util.function.Predicate;

class Person {

	public boolean isVote(Integer age) {
		return age >= 18;
	}

}

public class MethodReferenceExample3 {
	public static void main(String args[]) {

		Person p = new Person();
		Predicate<Integer> s1 = p::isVote;
		if (s1.test(18)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

	}
}
