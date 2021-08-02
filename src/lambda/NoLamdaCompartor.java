package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
	private int empId;
	private String empName;

	public Employee(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "{EmpId = " + this.getEmpId() + " EmpName= " + this.getEmpName() + "}";
	}

}

public class NoLamdaCompartor {
	public static void main(String args[]) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(3, "Guru"));
		employees.add(new Employee(2, "Shan"));
		employees.add(new Employee(1, "Cool"));

		Collections.sort(employees, new Comparator<Employee>() {
			public int compare(Employee o1, Employee o2) {
				return o1.getEmpId() - o2.getEmpId();
			};
		});
		
		System.out.println(Arrays.toString(employees.toArray()));

	}
}
