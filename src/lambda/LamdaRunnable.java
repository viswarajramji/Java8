package lambda;

public class LamdaRunnable {
	public static void main(String args[]) {
		Runnable r1 = () -> {
			System.out.println("run1");
		};
		Thread t1 = new Thread(r1);
		t1.start();

		Runnable r2 = () -> System.out.println("run2");
		Thread t2 = new Thread(r2);
		t2.start();
		
		
		new Thread(()->System.out.println("hello")).start();

	}
}
