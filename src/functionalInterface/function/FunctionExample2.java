package functionalInterface.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import data.Student;
import data.StudentDB;

public class FunctionExample2 {
	public static void main(String args[]) {
		List<Student> listStudents = StudentDB.getAllStudents();
		Function<List<Student>, Map<String, Student>> func = (List<Student> listStud) -> {
			Map<String, Student> mapStud = new HashMap<>();
			listStud.forEach((Student s) -> {
				mapStud.put(s.getName(), s);
			});
			return mapStud;
		};

		Map<String, Student> response = func.apply(listStudents);
		response.keySet().forEach((String key) -> {
			Student sval=response.get(key);
			System.out.println(sval.getName());
		});
	}
}
