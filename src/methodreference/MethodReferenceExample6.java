package methodreference;

import java.util.List;
import java.util.function.Supplier;

import data.Student;
import data.StudentDB;
//Predicate validation 
public class MethodReferenceExample6 {
	public static void main(String args[]) {
		List<Student> studentRecords = StudentDB.getAllStudents();
		studentRecords.forEach((Student s)->{
			Supplier<Boolean> isValid=s::isPassed;
			if(isValid.get()) {
				System.out.println(s.getName());
			}
		});
	}
}
