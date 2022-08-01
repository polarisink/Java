package github.polarisink.sync;

import java.util.stream.IntStream;

public class SaleTicket {
	public static void main(String[] args) {
		final Ticket ticket = new Ticket();
		Runnable runnable = () -> IntStream.range(0, 40).forEach(i -> ticket.sale());
		new Thread(runnable, "CC").start();
		new Thread(runnable, "BB").start();
		new Thread(runnable, "AA").start();
	}

}


class Ticket {
	private int numer = 30;

	public synchronized void sale() {
		if (numer > 0) {
			System.out.println(Thread.currentThread().getName() + ": 卖出: " + (30 - numer) + "剩下：" + numer--);
		}
	}
}
