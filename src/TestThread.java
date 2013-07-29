public class TestThread {
	public static void main(String[] args) {
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Hello world from the thread!");
			}
		};
		// Main thread don't wait for the daemon threads to finish!
		t.setDaemon(true);
		System.out.println(t.isDaemon());
		t.start();
	}
}
