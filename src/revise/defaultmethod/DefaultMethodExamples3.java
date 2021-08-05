package revise.defaultmethod;

import java.util.Comparator;
import java.util.List;

import data.Student;
import data.StudentDB;

interface SortByName {
	public default List<Student> sort(List<Student> list) {
		list.sort(Comparator.comparing(Student::getName));
		return list;
	}
}

interface SortByGPA {
	public default List<Student> sort(List<Student> list) {
		list.sort(Comparator.comparingDouble(Student::getGpa));
		return list;
	}
}

public class DefaultMethodExamples3 implements SortByName, SortByGPA {

	@Override
	public List<Student> sort(List<Student> list) {
		list.sort(Comparator.comparingInt(Student::getGradeLevel).reversed());
		return list;
	}

	public static void main(String args[]) {
		DefaultMethodExamples3 exp = new DefaultMethodExamples3();
		exp.sort(StudentDB.getAllStudents()).forEach(Student::printValue);
	}

}
