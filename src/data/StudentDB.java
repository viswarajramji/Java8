package data;

import java.util.Arrays;
import java.util.List;

public class StudentDB {

	public static List<Student> getAllStudents() {

		Student student1 = new Student("Adam", 2, 4.0, "male", 10,Arrays.asList("swimming", "basketball", "volleyball"),98,97);
		Student student2 = new Student("Jenny", 2, 3.8, "female", 11,Arrays.asList("swimming", "gymnastics", "soccer"),77,78);

		Student student3 = new Student("Emily", 3, 4.0, "female", 12,Arrays.asList("swimming", "gymnastics", "aerobics"),98,11);
		Student student4 = new Student("Dave", 3, 4.0, "male", 15, Arrays.asList("swimming", "gymnastics", "soccer"),56,78);

		Student student5 = new Student("Sophia", 4, 3.5, "female", 10,Arrays.asList("swimming", "dancing", "football"),89,92);
		Student student6 = new Student("James", 4, 3.9, "male", 22,Arrays.asList("swimming", "basketball", "baseball", "football"),44,88);

		List<Student> students = Arrays.asList(student1, student2, student3, student4, student5, student6);
		return students;
	}
}
