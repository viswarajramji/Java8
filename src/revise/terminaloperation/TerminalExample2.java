package revise.terminaloperation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TerminalExample2 {
	public static void main(String args[]) {
		System.out.println("Joining method");
		joining();
	}

	public static void joining() {
		List<String> values = Arrays.asList("1", "2", "3", "4");
		String join = values.stream().collect(Collectors.joining());
		System.out.println(join);

		String joiningDelimiter = values.stream().collect(Collectors.joining("-"));
		System.out.println(joiningDelimiter);

		String joiningPre = values.stream().collect(Collectors.joining("-", "(", ")"));
		System.out.println(joiningPre);
	}
}
