package github.polarisink.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lqs
 * @date 2022/8/3
 */
public class ReentrantLockTest {
  static Lock lock = new ReentrantLock();

  public static void main(String[] args) {
    new Thread(() -> {
      lock.lock();
      try {
        System.out.println(Thread.currentThread().getName() + "\t---come in外层");
        lock.lock();
        try {
          System.out.println(Thread.currentThread().getName() + "\t---come in内层");
        } finally {
          lock.unlock();
        }
      } finally {
        lock.unlock();
      }
    }, "t1").start();
  }


}
