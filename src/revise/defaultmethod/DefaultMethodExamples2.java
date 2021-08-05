package revise.defaultmethod;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

interface Area {
	public default List<String> sort(List<String> list) {
		list.sort(Comparator.naturalOrder());
		return list;
	}
}

class Reverse implements Area {
	public List<String> sort(List<String> list) {
		list.sort(Comparator.reverseOrder());
		return list;
	}
}

public class DefaultMethodExamples2 implements Area {

	public static void main(String args[]) {
		System.out.println("** natural ordering**");
		Area area = new DefaultMethodExamples2();
		List<String> values = Arrays.asList("5", "2", "3", "4");
		area.sort(values);
		values.forEach(System.out::println);

		System.out.println("** reverse ordering**");
		area = new Reverse();
		values = Arrays.asList("5", "2", "3", "4");
		area.sort(values);
		values.forEach(System.out::println);
	}

}
