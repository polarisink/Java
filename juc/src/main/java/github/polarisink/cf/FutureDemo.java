package github.polarisink.cf;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lqs
 * @date 2022/7/31
 */
public class FutureDemo {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		FutureTask<String> futureTask = new FutureTask<>(new MyThread2());
		Thread t = new Thread(futureTask, "tt");
		t.start();
		System.out.println(futureTask.get());
	}

}

class MyThread implements Runnable {

	@Override
	public void run() {

	}
}

class MyThread2 implements Callable<String> {

	@Override
	public String call() throws Exception {
		return "hello here call call()";
	}
}
