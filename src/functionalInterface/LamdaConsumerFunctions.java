package functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import data.Student;


public class LamdaConsumerFunctions {

	public static List<Student> list = new ArrayList<>();
	public static Consumer<Student> sId = (Student s) -> System.out.println(s.getStudId());
	public static Consumer<Student> sName = (Student s) -> System.out.println(s.getStudentName());

	public static void main(String args[]) {
		list.add(new Student(1, "User1"));
		list.add(new Student(2, "User2"));
		list.add(new Student(3, "User3"));
		list.add(new Student(4, "User4"));
		list.forEach((Student s) -> {
			sId.andThen(sName);
		});

	}
}
