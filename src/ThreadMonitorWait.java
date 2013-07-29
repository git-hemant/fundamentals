// Wait causes the release of monitor.
public class ThreadMonitorWait {
	public static void main(String[] args) {
		final Object monitor = new Object();
		Thread threadA = new Thread() {
			public void run() {
				synchronized (monitor) {
					System.out.println("Thread A started - waiting for 10 secs.");
					try {
						monitor.wait(10 * 1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Thread A finished.");					
				}
			}
		};
		Thread threadB = new Thread() {
			public void run() {
				synchronized (monitor) {
					System.out.println("Thread B started - waiting for 10 secs.");
					try {
						monitor.wait(10 * 1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Thread B finished.");					
				}
			}
		};
		
		threadA.start();
		threadB.start();
	}
}
