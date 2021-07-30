package functionalInterface.predicate;

import java.util.List;
import java.util.function.Predicate;

import data.Student;
import data.StudentDB;

public class PredicateExample1 {
	public static void main(String args[]) {
		Predicate<Student> isAvg=(Student s)->{
			return (s.getMark1()+s.getMark1())/2>70;
		};
		
		Predicate<Student> isSubPass=(Student s)->{
			return (s.getMark1()>50 && s.getMark2()>50);
		};
		List<Student> student=StudentDB.getAllStudents();
		student.forEach((Student s)->{
			if(isAvg.or(isSubPass).test(s)) {
				System.out.println(s.getName());
			}
		});
		
	}
}
