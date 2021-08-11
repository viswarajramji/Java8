package revise.methodreference;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import data.Student;
import data.StudentDB;

class Test {

	public String i;
	public String j;

	public Test() {

	}

	public Test(String i, String j) {
		this.i = i;
		this.j = j;
	}

	public String getI() {
		return i;
	}

	public void setI(String i) {
		this.i = i;
	}

	public String getJ() {
		return j;
	}

	public void setJ(String j) {
		this.j = j;
	}

	public void printInstanceName(Student s) {
		System.out.println(s.getName());
	}

	public static void printName(Student s) {
		System.out.println(s.getName());
	}
}

public class MethodReferenceExample1 {
	public static void main(String args[]) {
		instanceMethodReference();
		staticMethodReference();
		instanceMethodReferenceWithObject();
		constructorReferenceObject1();
		constructorReferenceObject2();
		constructorReferenceObject3();
	}

	public static void constructorReferenceObject3() {
		BiFunction<String, String, Test> biFunc = Test::new;
		Test test=biFunc.apply("testI", "testJ");
		System.out.println("I and J value");
		System.out.println(test.getI());
		System.out.println(test.getJ());
	}

	public static void constructorReferenceObject2() {
		Function<String, String> strFunc = String::new;
		String str = strFunc.apply("hello user");
		System.out.println(str);

	}

	public static void constructorReferenceObject1() {
		Supplier<String> strFunc = String::new;
		String str = strFunc.get();
		System.out.println(str);

	}

	public static void instanceMethodReferenceWithObject() {
		Test test = new Test();
		List<Student> listStudent = StudentDB.getAllStudents();
		System.out.println("instanceMethodReferenceWithObject");
		listStudent.forEach(test::printInstanceName);
	}

	public static void staticMethodReference() {
		System.out.println("static code reference");
		List<Student> listStudent = StudentDB.getAllStudents();
		listStudent.forEach(Test::printName);
	}

	public static void instanceMethodReference() {
		System.out.println("Instance code reference");
		List<Student> listStudent = StudentDB.getAllStudents();
		listStudent.stream().forEach(Student::printValue);
	}
}
