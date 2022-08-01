package github.polarisink.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author lqs
 * @date 2022/8/1
 */
public class CompletableFutureDemo {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		//不返回参数
		ExecutorService pool = Executors.newFixedThreadPool(3);
		/*CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			System.out.println(Thread.currentThread().getName());
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		System.out.println(future.get());*/

		CompletableFuture.supplyAsync(() -> {
			int i = ThreadLocalRandom.current().nextInt(10);
			System.out.println(Thread.currentThread().getName() + "come in");
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("三秒钟后出结果: " + i);
			return i;
		}).whenComplete((v, e) -> {
			if (e == null) {
				System.out.println("---计算完成,更新系统updateData---");
			}
			System.out.println();
		}).exceptionally(e -> {
			System.out.println("异常： " + e.getCause() + "\t" + e.getMessage());
			return null;
		});
		System.out.println(Thread.currentThread().getName() + "线程先去忙其他任务");
		//completableFuture中ForkJoinPool会自动关闭
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//有返回值
		//extracted();


	}

	private static void extracted() throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() -> {
			int i = ThreadLocalRandom.current().nextInt(10);
			System.out.println(Thread.currentThread().getName());
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("三秒钟后出结果: " + i);
			return i;
		});
		System.out.println(Thread.currentThread().getName() + "线程先去忙其他任务");
		System.out.println(supplyAsync.get());
	}

	public static void business() {
		System.out.println(Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
