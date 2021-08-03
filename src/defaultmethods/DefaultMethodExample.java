package defaultmethods;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import data.Student;
import data.StudentDB;

public class DefaultMethodExample {
	public static Comparator<Student> sortByName=Comparator.comparing(Student::getName);
	public static Comparator<Student> sortByGrade=Comparator.comparingDouble(Student::getGpa);
	public static void main(String args[]) {
		basic();
		sortValues();
		sortNullValue();
	}
	
	public static void sortNullValue() {
		System.out.println(" **** Null Value *****");
		Comparator<Student> allowNulls=Comparator.nullsFirst(sortByName);
		List<Student> students=StudentDB.getAllStudents();
		//students.add(null);
		students.sort(allowNulls);
		students.forEach(Student::printValue);

		
	}

	public static void sortValues() {
		System.out.println("Sorting *****");
		List<Student> students=StudentDB.getAllStudents();
		students.sort(sortByName.thenComparing(sortByGrade));
		students.forEach(Student::printValue);
	}

	public static void basic() {
		List<String> listValue = Arrays.asList("c", "a", "b");
		listValue.sort(Comparator.naturalOrder());
		System.out.println(Arrays.toString(listValue.toArray()));
		System.out.println("**Reverse Order**");
		listValue = Arrays.asList("c", "b", "a");
		listValue.sort(Comparator.reverseOrder());
		System.out.println(Arrays.toString(listValue.toArray()));
	}

}
