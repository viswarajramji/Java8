package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class InternalWorkingStreams {
	public static void main(String args[]) {
		Integer arr[] = { 1, 2, 3, 4 };
		List<Integer> list = Arrays.asList(arr);
		// list can be modified & stream cannot be modified

		// list.stream().add() invalid

		// list elements can be accessed in any order by stream can be accessed in seq
		System.out.println(list.get(2));

		// List is eager loading //stream is lazy loading

		// list can be tranversed n number of times // Stream can be processed only once
		System.out.println("Normal printing");
		for (Integer val : list) {
			System.out.println(val);
		}
		System.out.println("Stream printing");
		Stream<Integer> streams=list.stream();
		streams.forEach((Integer i)->System.out.println(i));
		
		//streams.forEach((Integer i)->System.out.println(i)); --stream closed

	}
}
