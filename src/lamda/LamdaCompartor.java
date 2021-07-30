package lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LamdaCompartor {
	public static void main(String args[]) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(3, "Guru"));
		employees.add(new Employee(2, "Shan"));
		employees.add(new Employee(1, "Cool"));

		Comparator<Employee> compartor = (Employee o1, Employee o2) -> {
			return o1.getEmpId() - o2.getEmpId();
		};

		Collections.sort(employees, compartor);

		System.out.println("Ascending order");

		System.out.println(Arrays.toString(employees.toArray()));

		System.out.println("Descending order");

		Collections.sort(employees, (Employee o1, Employee o2) -> {
			return o2.getEmpId() - o1.getEmpId();
		});

		System.out.println(Arrays.toString(employees.toArray()));

	}
}
