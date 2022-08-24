package github.polarisink.cas;

import sun.misc.Unsafe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 手写自旋锁
 *
 * @author hzsk
 */
public class AtomicReferenceThreadDemo {
  static AtomicReference<Thread> atomicReference = new AtomicReference<>();
  static Thread thread;

  public static void lock() {
    thread = Thread.currentThread();
    System.out.println(Thread.currentThread().getName() + "\t" + "coming.....");
    while (!atomicReference.compareAndSet(null, thread)) {

    }
  }

  public static void unlock() {
    System.out.println(Thread.currentThread().getName() + "\t" + "over.....");
    atomicReference.compareAndSet(thread, null);
  }

  public static void main(String[] args) {
    new Thread(() -> {
      AtomicReferenceThreadDemo.lock();
      try {
        TimeUnit.SECONDS.sleep(3);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      AtomicReferenceThreadDemo.unlock();
    }, "A").start();

    new Thread(() -> {
      AtomicReferenceThreadDemo.lock();
      AtomicReferenceThreadDemo.unlock();
    }, "B").start();
  }
}
