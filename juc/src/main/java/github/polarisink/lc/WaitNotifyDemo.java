package github.polarisink.lc;

import java.util.concurrent.TimeUnit;

/**
 * 使用wait和notify,必须线持有锁才能使用
 * @author lqs
 * @date 2022/8/14
 */
public class WaitNotifyDemo {
	public static void main(String[] args) {
		Object o = new Object();
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (o){
				System.out.println(Thread.currentThread().getName()+"\t---come in");
				try {
					o.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"\t---被唤醒");
			}
		},"t1").start();

		new Thread(()->{
			synchronized (o){
				o.notify();
				System.out.println(Thread.currentThread().getName()+"\t---发出通知");
			}
		},"t2").start();
	}
}
