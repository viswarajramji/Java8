package streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDB;

public class StreamFunctionExamples {
	public static List<Student> students = StudentDB.getAllStudents();

	public static void main(String args[]) {
		map();
		flatMap();
		distinct();
		count();
		sort();
		customSort();
		filter();
		
	}
	public static void filter() {
		//activities containing swimming.
		List<Student> resultList=students.stream().filter(s->s.getActivity().contains("swimming")).collect(Collectors.toList());
		resultList.forEach(Student::printValue);
	}
	
	public static void customSort() {
		System.out.println("**CustomSort**");
		List<String> result=students.stream().distinct().sorted(Comparator.comparing(Student::getName)).map(Student::getName).collect(Collectors.toList());
		System.out.println(result);
	}
	
	public static void sort() {
		System.out.println("**sort**");
		List<String> result=students.stream().map(Student::getActivity).flatMap(List::stream).distinct().sorted().collect(Collectors.toList());
		System.out.println(result);
	}
	
	public static void count() {
		System.out.println("**count**");
		Long count=students.stream().map(Student::getActivity).flatMap(List::stream).distinct().count();
		System.out.println(count);
	}

	public static void distinct() {
		System.out.println("**Distinct**");
		List<String> resultList=students.stream().map(Student::getActivity).flatMap(List::stream).distinct().collect(Collectors.toList());
		System.out.println(resultList);
	}
	
	
	public static void flatMap() {
		System.out.println("**flat map**");
		List<String> resultList=students.stream().map(Student::getActivity).flatMap(List::stream).collect(Collectors.toList());
		System.out.println(resultList);
	}

	public static void map() {
		System.out.println("**map**");
		List<String> resultList = students.stream().map(Student::getName).map(String::toUpperCase)
				.collect(Collectors.toList());
		System.out.println(resultList);
	}

}
