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
		parallelLessPerformance();
		notToUseParallel();

	}

	public static void notToUseParallel() {
		Sum sumStream = new Sum();
		List<Integer> listStream = IntStream.range(1, 100).boxed().collect(Collectors.toList());
		listStream.stream().forEach(sumStream::performAdd);
		
		Sum sumParallel = new Sum();
		List<Integer> listParallel = IntStream.range(1, 100).boxed().collect(Collectors.toList());
		listParallel.parallelStream().forEach(sumParallel::performAdd);
		
		System.out.println("total Stream " + sumStream.getValue());
		System.out.println("total Parallel " + sumParallel.getValue());
	}

	public static void parallelLessPerformance() {
		streamPerformance();
		parallelPerformance();
	}

	public static void parallelPerformance() {
		long startTime = System.currentTimeMillis();
		List<Integer> list = IntStream.range(1, 100000).boxed().collect(Collectors.toList());
		Integer value = list.parallelStream().reduce(0, (x, y) -> x + y);
		System.out.println(value);
		long endTime = System.currentTimeMillis();
		System.out.println("Pallel : " + (endTime - startTime));
	}

	public static void streamPerformance() {
		long startTime = System.currentTimeMillis();
		List<Integer> list = IntStream.range(1, 100000).boxed().collect(Collectors.toList());
		Integer value = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println(value);
		long endTime = System.currentTimeMillis();
		System.out.println("Pallel : " + (endTime - startTime));
	}

	public static void realUseCaseStream() {
		long startTime = System.currentTimeMillis();
		List<Student> students = StudentDB.getAllStudents();
		List<String> list = students.stream().filter(s -> s.getGpa() == 4.0).map(Student::getName).sorted()
				.collect(Collectors.toList());
		if (!list.isEmpty())
			list.forEach(System.out::println);
		else
			System.out.println("No Records found");
		long endTime = System.currentTimeMillis();
		System.out.println("time Stream -- " + (endTime - startTime));
	}

	public static void realUseCaseParallelStream() {
		long startTime = System.currentTimeMillis();
		List<Student> students = StudentDB.getAllStudents();
		List<String> list = students.parallelStream().filter(s -> s.getGpa() == 4.0).map(Student::getName).sorted()
				.collect(Collectors.toList());
		if (!list.isEmpty())
			list.forEach(System.out::println);
		else
			System.out.println("No Records found");
		long endTime = System.currentTimeMillis();
		System.out.println("time parallel -- " + (endTime - startTime));
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
