package functionalInterface;

import java.util.function.Predicate;

public class PredicateFunctions {

	static void basic() {
		Predicate<Integer> p1 = (Integer i) -> {
			return i % 5 == 0;
		};
		System.out.println(p1.test(10));
		System.out.println(p1.test(11));
	}

	static void andOperations() {
		System.out.println("AND Operations");
		System.out.println("--------------");
		Predicate<Integer> p1 = (Integer a) -> {
			return a % 5 == 0;
		};

		Predicate<Integer> p2 = (Integer b) -> {
			return b % 5 == 0;
		};

		System.out.println(p1.and(p2).test(10));
		System.out.println(p1.and(p2).test(11));
		System.out.println("--------------");
	}

	static void orOperations() {
		System.out.println("OR Operations");
		System.out.println("--------------");
		Predicate<Integer> p1 = (Integer a) -> {
			return a % 5 == 0;
		};

		Predicate<Integer> p2 = (Integer b) -> {
			return b % 5 == 0;
		};

		System.out.println(p1.or(p2).test(10));
		System.out.println(p1.or(p2).test(11));
		System.out.println("--------------");
	}

	static void negateOperation() {
		System.out.println("Negate Operations");
		System.out.println("--------------");
		Predicate<Integer> p1 = (Integer a) -> {
			return a % 5 == 0;
		};
		System.out.println(p1.negate().test(10));

	}

	public static void main(String args[]) {
		basic();
		andOperations();
		orOperations();
		negateOperation();

	}
}
