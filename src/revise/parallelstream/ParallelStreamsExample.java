package revise.parallelstream;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import data.Student;
import data.StudentDB;

public class ParallelStreamsExample {
	public static void main(String args[]) {
		performance(ParallelStreamsExample::Stream, 1000);
		performance(ParallelStreamsExample::parallelStream, 1000);
		availableProcessor();
		realUseCaseStream();
		realUseCaseParallelStream();

	}

	public static void realUseCaseStream() {
		long startTime = System.currentTimeMillis();
		List<Student> students = StudentDB.getAllStudents();
		List<String> list = students.stream().filter(s -> s.getGpa() == 4.0).map(Student::getName).sorted().collect(Collectors.toList());
		if (!list.isEmpty())
			list.forEach(System.out::println);
		else
			System.out.println("No Records found");
		long endTime = System.currentTimeMillis();
		System.out.println("time Stream -- "+(endTime - startTime));
	}

	public static void realUseCaseParallelStream() {
		long startTime = System.currentTimeMillis();
		List<Student> students = StudentDB.getAllStudents();
		List<String> list = students.parallelStream().filter(s -> s.getGpa() == 4.0).map(Student::getName).sorted().collect(Collectors.toList());
		if (!list.isEmpty())
			list.forEach(System.out::println);
		else
			System.out.println("No Records found");
		long endTime = System.currentTimeMillis();
		System.out.println("time parallel -- "+(endTime - startTime));
	}

	public static void availableProcessor() {
		System.out.println("Get Available Processor : " + Runtime.getRuntime().availableProcessors());
	}

	public static void performance(Supplier<Integer> supplier, int num) {
		Long start = System.currentTimeMillis();
		for (int i = 0; i < num; i++) {
			supplier.get();
		}
		Long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static Integer Stream() {
		return IntStream.rangeClosed(1, 100).sum();
	}

	public static Integer parallelStream() {
		return IntStream.rangeClosed(1, 100).sum();
	}

}
