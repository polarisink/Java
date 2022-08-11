package github.polarisink.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author lqs
 * @date 2022/8/11
 */
public class InterruptTest2 {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			while (true) {
				if (Thread.currentThread().isInterrupted()) {
					System.out.println(Thread.currentThread().getName() + "\t" + "中断标示位:" + Thread.currentThread().isInterrupted() + "程序停止");
					break;
				}
				System.out.println("hello interruptTest2");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "t1");
		t1.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		}catch (InterruptedException e){
			//TODO 此处不处理会死循环:抛异常会清除中断位,需要再加一次interrupt
			//Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		new Thread(()->t1.interrupt(),"t2").start();
	}
}
