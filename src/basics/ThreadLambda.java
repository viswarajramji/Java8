package basics;

public class ThreadLambda {
	public static void main(String arg[]) {
		Runnable r = () -> {
			System.out.println("this is the new thread");
		};

		Thread t = new Thread(r);
		t.start();
	}
}
