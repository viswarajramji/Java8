package functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BiConsumerFunction {
	public static List<Student> list = new ArrayList<>();
	public static Consumer<Student> sId = (Student s) -> System.out.println(s.getStudId());
	public static Consumer<Student> sName = (Student s) -> System.out.println(s.getStudentName());

	public static void main(String args[]) {

		BiConsumer<Integer, Integer> biConsumerAdd = (Integer a, Integer b) -> {
			System.out.println(a + b);
		};

		BiConsumer<Integer, Integer> biConsumerSub = (Integer a, Integer b) -> {
			System.out.println(a - b);
		};

		list.add(new Student(1, "User1", 100, 200));
		list.add(new Student(2, "User2", 10, 20));
		list.add(new Student(3, "User3", 40, 50));
		list.add(new Student(4, "User4", 10, 90));

		list.forEach((Student s) -> {
			biConsumerAdd.andThen(biConsumerSub).accept(s.getMark1(), s.getMark2());
		});

	}
}
