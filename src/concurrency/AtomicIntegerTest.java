package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

	public static void main(String[] args) {
		
		AtomicInteger atomicInteger = new AtomicInteger(0);
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		for (int i = 0; i < 100; i++) executorService.submit(new TestTask<Object>(atomicInteger));
		// Now shutdown - this will wait till all the existing tasks are finished.
		executorService.shutdown();
		// Now wait till all the tasks is finished.
		try {
			while (!executorService.awaitTermination(30, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Value of atomic integer is: " + atomicInteger.intValue() + " Expected value is: " + (100000));
	}
	
	static class TestTask<V> implements Callable<V> {
		private AtomicInteger ai;
		TestTask(AtomicInteger ai) {
			this.ai = ai;
		}
		
		public V call() throws Exception {
			// Increment the AtomicInteger 
			for (int i = 0; i < 100000; i++) ai.incrementAndGet();
			return null;
		}
	}
}
