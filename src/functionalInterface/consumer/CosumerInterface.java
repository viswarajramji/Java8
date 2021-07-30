package functionalInterface.consumer;

import java.util.List;
import java.util.function.Consumer;

import data.Student;
import data.StudentDB;

public class CosumerInterface {
	public static void main(String args[]) {
		Consumer<Student> c1=(Student s)->{
			System.out.print("Name : "+s.getName());
		};
		
		Consumer<Student> c2=(Student s)->{
			System.out.println(" Gender: "+s.getGender());
		};
 		List<Student> listStudents=StudentDB.getAllStudents();
		listStudents.forEach(c1.andThen(c2));
	}
}
