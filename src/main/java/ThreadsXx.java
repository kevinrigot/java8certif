import java.util.concurrent.atomic.AtomicInteger;

public class ThreadsXx {
	private static class CStore implements Runnable {
		int x = 1;
		private AtomicInteger cps = new AtomicInteger(10);

		public void run() {
			while (x > 0) {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					System.out.print(e);
				}
				synchronized (this) {
					x = cps.decrementAndGet();
				}
				System.out.print(cps);
			}
		}
	}

	public static void main(String args[]) {
		CStore cs = new CStore();
		Thread th1 = new Thread(cs);
		Thread th2 = new Thread(cs);
		th1.start();
		th2.start();
	}
}