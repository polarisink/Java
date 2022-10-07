package github.polarisink.cas;

import java.util.concurrent.Semaphore;

/**
 * @author hzsk
 */
public class SemaphoreDemo {
  public static void main(String[] args) {
    Semaphore semaphore = new Semaphore(3);
    for (int i = 1; i <= 6; i++) {
      new Thread(() -> {
        try {
          System.out.println(Thread.currentThread().getName() + "\t抢占了车位");
          semaphore.acquire();
          System.out.println(Thread.currentThread().getName() + "\t离开了车位");
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          semaphore.release();
        }
      }, String.valueOf(i)).start();
    }
  }
}
