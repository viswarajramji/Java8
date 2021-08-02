package lambda;

public class NoLamdaRunnable {
	public static void main(String args[]) {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("Thread started");
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();
	}
}
