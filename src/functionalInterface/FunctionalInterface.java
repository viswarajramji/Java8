package functionalInterface;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import data.Student;
import data.StudentDB;

public class FunctionalInterface {
	public static void main(String args[]) {
		
		Function<Student,Integer> performAvg=(Student s)->{
			return (s.getMark1()+s.getMark2())/2;
		};
		
		Predicate<Integer> isAvg=(Integer a)->{
			return a>90;
		};
		Consumer<Student> consumers = (Student s) -> {
			Integer avg=performAvg.apply(s);
			if(isAvg.test(avg)) {
				System.out.println(s.getName());
			}
		};
		List<Student> studentList = StudentDB.getAllStudents();
		studentList.forEach(consumers);
	}
}
