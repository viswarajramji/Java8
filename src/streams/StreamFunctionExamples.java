package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
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
		reduce();
		reduceComp();
		mapFilterReduce();
		maxValue();
		minValue();
		limit();
		skip();
		allMatch();
		anyMatch();
		noMatch();
		
	}

	public static void noMatch() {
		// all the values should match by predicate
		Predicate<Student> allMatchPre=(s->s.getGpa()>4.0);
		boolean isValid= students.stream().noneMatch(allMatchPre);
		System.out.println(isValid);
		
	}
	
	public static void anyMatch() {
		// all the values should match by predicate
		Predicate<Student> allMatchPre=(s->s.getGpa()>4.0);
		boolean isValid= students.stream().anyMatch(allMatchPre);
		System.out.println(isValid);
		
	}
	
	public static void allMatch() {
		// all the values should match by predicate
		Predicate<Student> allMatchPre=(s->s.getGpa()>1.0);
		boolean isValid= students.stream().allMatch(allMatchPre);
		System.out.println(isValid);
		
	}
	
	public static void skip() {
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> val = values.stream().skip(3).reduce((a, b) -> a + b);
		if (val.isPresent()) {
			System.out.println("skip value " + val.get());
			return;
		}
		System.out.println("No sum value found");
	}
	
	
	public static void limit() {
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> val = values.stream().limit(3).reduce((a, b) -> a + b);
		if (val.isPresent()) {
			System.out.println("Limit value " + val.get());
			return;
		}
		System.out.println("No sum value found");
	}

	public static void maxValue() {
		List<Integer> values=Arrays.asList(1,2,3,4,5);
		Optional<Integer> max=values.stream().reduce((a,b)->a>b?a:b);
		if(max.isPresent()) {
			System.out.println(max.get());
			return;
		}
		System.out.println("No max value found");
	}
	
	public static void minValue() {
		List<Integer> values=Arrays.asList(1,2,3,4,5);
		Optional<Integer> min=values.stream().reduce((a,b)->a>b?b:a);
		if(min.isPresent()) {
			System.out.println(min.get());
			return;
		}
		System.out.println("No min value found");
	}

	public static void mapFilterReduce() {
		Optional<Integer> maxValue = students.stream().filter(s -> s.getGradeLevel() >= 3).map(Student::getMark1)
				.reduce((a, b) -> a > b ? a : b);
		System.out.println(maxValue.get());
	}

	public static void reduceComp() {
		Optional<Student> maxScore = students.stream().reduce((s1, s2) -> {
			if (s1.getGpa() > s2.getGpa()) {
				return s1;
			} else {
				return s2;
			}
		});
		if (maxScore.isPresent()) {
			System.out.println(maxScore.get().getName() + "__" + maxScore.get().getGpa());
		}

	}

	public static void reduce() {
		int totalMarks1 = students.stream().map(Student::getMark1).reduce(0, (a, b) -> a + b);
		int totalMarks2 = students.stream().map(Student::getMark2).reduce(0, (a, b) -> a + b);
		System.out.println(totalMarks1 + " " + totalMarks2);
	}

	public static void filter() {
		// activities containing swimming.
		List<Student> resultList = students.stream().filter(s -> s.getActivity().contains("swimming"))
				.collect(Collectors.toList());
		resultList.forEach(Student::printValue);
	}

	public static void customSort() {
		System.out.println("**CustomSort**");
		List<String> result = students.stream().distinct().sorted(Comparator.comparing(Student::getName))
				.map(Student::getName).collect(Collectors.toList());
		System.out.println(result);
	}

	public static void sort() {
		System.out.println("**sort**");
		List<String> result = students.stream().map(Student::getActivity).flatMap(List::stream).distinct().sorted()
				.collect(Collectors.toList());
		System.out.println(result);
	}

	public static void count() {
		System.out.println("**count**");
		Long count = students.stream().map(Student::getActivity).flatMap(List::stream).distinct().count();
		System.out.println(count);
	}

	public static void distinct() {
		System.out.println("**Distinct**");
		List<String> resultList = students.stream().map(Student::getActivity).flatMap(List::stream).distinct()
				.collect(Collectors.toList());
		System.out.println(resultList);
	}

	public static void flatMap() {
		System.out.println("**flat map**");
		List<String> resultList = students.stream().map(Student::getActivity).flatMap(List::stream)
				.collect(Collectors.toList());
		System.out.println(resultList);
	}

	public static void map() {
		System.out.println("**map**");
		List<String> resultList = students.stream().map(Student::getName).map(String::toUpperCase)
				.collect(Collectors.toList());
		System.out.println(resultList);
	}

}
