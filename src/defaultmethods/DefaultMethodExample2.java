package defaultmethods;

interface User {
	default void printName(String name) {
		System.out.println("the UserName : "+name);
	}
}

interface Admin {
	default void printName(String name) {
		System.out.println("the AdminName : "+name);
	}
}

public class DefaultMethodExample2 implements User,Admin {
	
	@Override
	public void printName(String name) {
		User.super.printName(name);
		Admin.super.printName(name);
	}

	
	public static void main(String args[]) {
		DefaultMethodExample2 exVal = new DefaultMethodExample2();
		exVal.printName("test");
	}


}
