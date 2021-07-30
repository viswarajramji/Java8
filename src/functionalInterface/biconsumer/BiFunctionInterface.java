package functionalInterface.biconsumer;

import java.util.function.BiConsumer;

import data.Student;
import data.StudentDB;

public class BiFunctionInterface {
	public static void main(String args[]) {
		Student oldObject= StudentDB.getAllStudents().get(0);
		Student newObject= StudentDB.getAllStudents().get(1);
		BiConsumer<Student, Student> diff=(Student oldObj,Student newObj)->{
			if(oldObj.getName()!=newObj.getName()) {
				System.out.println("Changed Name Old : "+oldObj.getName()+" New : "+newObj.getName());
			}
		};
		diff.accept(oldObject, newObject);
		
		
	}
}
