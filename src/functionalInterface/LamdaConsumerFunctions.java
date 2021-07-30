package functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class Student {
	private int studId;
	private String studentName;
	private int mark1;
	private int mark2;

	public Student(int studId, String studentName) {
		this.studId = studId;
		this.studentName = studentName;
	}

	public Student(int studId, String studentName, int mark1, int mark2) {
		super();
		this.studId = studId;
		this.studentName = studentName;
		this.mark1 = mark1;
		this.mark2 = mark2;
	}

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getMark1() {
		return mark1;
	}

	public void setMark1(int mark1) {
		this.mark1 = mark1;
	}

	public int getMark2() {
		return mark2;
	}

	public void setMark2(int mark2) {
		this.mark2 = mark2;
	}

}

public class LamdaConsumerFunctions {

	public static List<Student> list = new ArrayList<>();
	public static Consumer<Student> sId = (Student s) -> System.out.println(s.getStudId());
	public static Consumer<Student> sName = (Student s) -> System.out.println(s.getStudentName());

	public static void main(String args[]) {
		list.add(new Student(1, "User1"));
		list.add(new Student(2, "User2"));
		list.add(new Student(3, "User3"));
		list.add(new Student(4, "User4"));
		list.forEach((Student s) -> {
			sId.andThen(sName);
		});

	}
}
