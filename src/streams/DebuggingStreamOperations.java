package streams;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDB;

public class DebuggingStreamOperations {
	public static void main(String args[]) {
		Predicate<Student> stuPre = (Student s) -> {
			return s.getMark1() > 90 && s.getMark2() > 90;
		};
		Consumer<Student> consumer1=(Student s)->{
			System.out.println("Consumer1 test");
			System.out.println(s.getName());
		};
		
		Consumer<Student> consumer2=(Student s)->{
			System.out.println("Consumer2 test");
			System.out.println(s.getName());
		};
		List<Student> listStd = StudentDB.getAllStudents();
		List<Student> res=listStd.stream()
				.peek(consumer1)
				.filter(stuPre)
				.peek(consumer2)
				.collect(Collectors.toList());
		System.out.println("Priting the result");
		res.forEach((Student s) -> {
			System.out.println(s.getName());
		});
	}
}
