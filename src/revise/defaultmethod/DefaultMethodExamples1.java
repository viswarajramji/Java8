package revise.defaultmethod;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import data.Student;
import data.StudentDB;

public class DefaultMethodExamples1 {

	public static void main(String args[]) {
		ordering();
		sortByName();
		sortWithNull();
	}

	public static void sortWithNull() {
		System.out.println("*** sortByName  null values** ");
		List<Student> student = StudentDB.getAllStudents();
		Comparator<Student> sortByName = Comparator.comparing(Student::getName);
		Comparator<Student> sottByNullValFirst = Comparator.nullsFirst(sortByName);
		student.sort(sottByNullValFirst);
		student.forEach(Student::printValue);

		Comparator<Student> sottByNullValLast = Comparator.nullsLast(sortByName);
		student.sort(sottByNullValLast);
		student.forEach(Student::printValue);
	}

	public static void sortByName() {
		System.out.println("*** sortByName ** ");
		List<Student> student = StudentDB.getAllStudents();
		Comparator<Student> sortByName = Comparator.comparing(Student::getName);
		student.sort(sortByName);
		student.forEach(Student::printValue);

		System.out.println("*** sortByDouble ** ");
		Comparator<Student> sortByNumber = Comparator.comparingDouble(Student::getGpa);
		student.sort(sortByNumber);
		student.forEach(Student::printValue);

		System.out.println("*** sortByName & sortByDouble ** ");
		student.sort(sortByName.thenComparing(sortByNumber));
		student.forEach(Student::printValue);

	}

	public static void ordering() {
		System.out.println("*** ordering sorting natural and reverse");
		List<String> list = Arrays.asList("2", "3", "1");
		list.sort(Comparator.naturalOrder());
		System.out.println(Arrays.toString(list.toArray()));
		list.sort(Comparator.reverseOrder());
		System.out.println(Arrays.toString(list.toArray()));
	}

}
