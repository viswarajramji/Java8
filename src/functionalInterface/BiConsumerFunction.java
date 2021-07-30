package functionalInterface;

import java.util.List;
import java.util.function.BiConsumer;

import data.Student;
import data.StudentDB;

public class BiConsumerFunction {

	public static void main(String args[]) {
		List<Student> students = StudentDB.getAllStudents();

		BiConsumer<String , Integer> biConsumerAdd = ( a, Integer b) -> {
			System.out.println(a + b);
		};

		BiConsumer<Integer, Integer> biConsumerSub = (Integer a, Integer b) -> {
			System.out.println(a - b);
		};

		students.forEach((Student s) -> {
			biConsumerAdd.andThen(biConsumerSub).accept(s.getGpa(), s.getMark2());
		});

	}
}
