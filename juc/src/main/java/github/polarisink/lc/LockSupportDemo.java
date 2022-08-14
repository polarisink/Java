package github.polarisink.lc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 通过permit许可,先unpark再park依旧生效
 *
 * @author lqs
 * @date 2022/8/14
 */
public class LockSupportDemo {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "\t---come in");
			LockSupport.park();
			System.out.println(Thread.currentThread().getName() + "\t---被唤醒");
		}, "t1");
		t1.start();

		/**
		 * 如果给定线程尚不可用，则为其提供许可。 如果该线程在park上被阻止，则它将解除阻止。
		 * 否则，它的下一次调用park保证不会阻止。 如果尚未启动给定线程，则不保证此操作完全没有任何效果。
		 */
		new Thread(() -> {
			LockSupport.unpark(t1);
			System.out.println(Thread.currentThread().getName() + "\t---发出通知");
		}, "t2").start();
	}
}
