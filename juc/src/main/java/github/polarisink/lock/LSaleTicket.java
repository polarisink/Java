package github.polarisink.lock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class LSaleTicket {
	public static void main(String[] args) {
		final LTicket ticket = new LTicket();
		Runnable runnable = () -> IntStream.range(0, 40).forEach(i -> ticket.sale());
		new Thread(runnable, "CC").start();
		new Thread(runnable, "BB").start();
		new Thread(runnable, "AA").start();
	}

}


class LTicket {
	private int numer = 30;
	private final ReentrantLock lock = new ReentrantLock();

	public void sale() {
		lock.lock();
		try {
			if (numer +1> 0) {
				System.out.println(Thread.currentThread().getName() + ": 卖出: " + (30 - numer) + "剩下：" + numer--);
			}
		} finally {
			lock.unlock();
		}
	}
}
