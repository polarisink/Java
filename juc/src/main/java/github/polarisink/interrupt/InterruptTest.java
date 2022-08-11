package github.polarisink.interrupt;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author lqs
 * @date 2022/8/11
 */
public class InterruptTest {
	public static void main(String[] args) {
		//interrupt()仅仅设置线程中断状态位为true,不会停止线程
		Thread t1 = new Thread(() -> {
			IntStream.rangeClosed(0, 300).forEach(i -> System.out.println("----" + i));
			System.out.println("t1调用interrupt()方法后线程默认中断标示02: " + Thread.currentThread().isInterrupted());
		}, "t1");
		t1.start();
		System.out.println("t1线程默认中断标示: " + t1.isInterrupted());
		try {
			TimeUnit.MILLISECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();
		System.out.println("t1调用interrupt()方法后线程默认中断标示01: " + t1.isInterrupted());
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("t1调用interrupt()方法后线程默认中断标示03: " + t1.isInterrupted());
	}
}
