package github.polarisink.sync;

/**
 * @author aries
 * @date 2022/8/24
 */
public class LockDemo {
  private final Object lock = new Object();

  public void m1() {
    synchronized (lock) {
      System.out.println("-------lock-------");
    }
  }
}
