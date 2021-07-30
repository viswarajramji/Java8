package functionalInterface.consumer;

import java.util.List;
import java.util.function.Consumer;

import data.Student;
import data.StudentDB;

public class ConsumerInterfaceExample2 {
	public static void main(String args[]) {
		
		Consumer<Student> sum=(Student s)->{
			System.out.println("Sum="+(s.getMark1()+s.getMark2()));
		};
		
		Consumer<Student> avg=(Student s)->{
			System.out.println("Avg="+(s.getMark1()+s.getMark2())/2);
		};
		List<Student> listStudents=StudentDB.getAllStudents();
		listStudents.forEach((Student s)->{
			if(s.getGender().equals("male")) {
				System.out.println("Name : "+s.getName());
				sum.andThen(avg).accept(s);
			}
		});
	}
}
