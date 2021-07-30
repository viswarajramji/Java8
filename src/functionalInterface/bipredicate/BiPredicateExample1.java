package functionalInterface.bipredicate;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import data.Student;
import data.StudentDB;

public class BiPredicateExample1 {
	public static void main(String args[]) {
		List<Student> studentList = StudentDB.getAllStudents();

		Predicate<Student> avg = (Student s) -> {
			return (s.getMark1() + s.getMark2() / 2) > 70;
		};

		Predicate<Student> sum = (Student s) -> {
			return (s.getMark1() > 50 && s.getMark2() > 50);
		};

		BiPredicate<Student, Predicate<Student>> isValid = (Student s, Predicate<Student> pred) -> {
			return pred.test(s);
		};

		studentList.forEach((Student s) -> {
			if(isValid.test(s, avg.and(sum))) {
				System.out.println(s.getName());
			}
		});

	}
}
