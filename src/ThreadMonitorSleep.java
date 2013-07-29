// Thread.sleep doesn't releases the monitor, so we should never ever
// sleep the thread which is holding the monitors.
public class ThreadMonitorSleep {
	public static void main(String[] args) {
		final Object monitor = new Object();
		Thread threadA = new Thread() {
			public void run() {
				synchronized (monitor) {
					System.out.println("Thread A started - sleeping for 10 secs.");
					try {
						Thread.sleep(10 * 1000);
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
					System.out.println("Thread B started - sleeping for 10 secs.");
					try {
						Thread.sleep(10 * 1000);
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
