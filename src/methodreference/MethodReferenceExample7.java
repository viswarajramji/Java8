package methodreference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class Utility{
	public static void print(Integer i) {
		System.out.println(i);
	}
}
class Admin {
	private Integer age;

	public Admin(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}

public class MethodReferenceExample7 {
	public static void main(String args[]) {
		List<Admin> listAdmin = new ArrayList<>();
		listAdmin.add(new Admin(50));
		listAdmin.add(new Admin(17));
		listAdmin.add(new Admin(25));

		Consumer<Integer> consumer=Utility::print;
		listAdmin.forEach((Admin a) -> {
			consumer.accept(a.getAge());
		});
	}
}
