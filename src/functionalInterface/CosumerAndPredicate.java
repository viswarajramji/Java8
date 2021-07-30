package functionalInterface;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import data.Student;
import data.StudentDB;

public class CosumerAndPredicate {

	Predicate<Student> gpa = (Student s) -> {
		return s.getGpa() >= 3;
	};

	Predicate<Student> gradeLevel = (Student s) -> {
		return s.getGradeLevel() >= 3.9;
	};
	
	BiConsumer<String,String> print = (String a, String b)->{
			System.out.println(a +" , "+ b);
	};

	Consumer<Student> studentCons = (Student s) -> {
		if (gpa.and(gradeLevel).test(s)) {
			print.accept(s.getName(), s.getGender());
		}
	};
	
	BiPredicate<Integer, Integer> isPass=(Integer s1,Integer s2)->{
		return s1 > 50 && s2>50;
	};
	
	Consumer<Student> getPassList=(Student s)->{
		if(isPass.test(s.getMark1(), s.getMark2())) {
			System.out.println(s.getName() +"__"+s.getGender() );
		}
	};
	

	public void displayValues(List<Student> students) {
		students.forEach(studentCons);
		System.out.println("***Pass List***");
		students.forEach(getPassList);
		
	}
	
	public static void main(String args[]) {
		CosumerAndPredicate consumerPre=new CosumerAndPredicate();
		List<Student> students = StudentDB.getAllStudents();
		consumerPre.displayValues(students);
	}
}
