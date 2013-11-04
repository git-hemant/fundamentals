import java.util.concurrent.atomic.AtomicInteger;


public class TestThreadLocal
{
	
	public static void main(String[] args)
	{
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread() { 
				public void run() {
					System.out.println(getCurrentThreadId());
				}
			};
			t.start();
		}
	}
	
     private static final AtomicInteger uniqueId = new AtomicInteger(0);

     private static final ThreadLocal < Integer > uniqueNum = 
         new ThreadLocal < Integer > () {
             @Override protected Integer initialValue() {
                 return uniqueId.getAndIncrement();
         }
     };
 
     public static int getCurrentThreadId() {
         return uniqueId.get();
     }
}
