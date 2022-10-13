package github.polarisink.reentrant;

/**
 * 测试synchronized可重入锁<br/>
 * synchronized修饰的方法或代码快调用本类其他synchronized修饰的方法或代码块时，永远可以得到锁<br/>
 * 原理:<br/>
 * 1、每个对象拥有一个锁计数器和一个指向持有该锁的线程的指针;当执行monitoeenter时,如果目标锁对象计数器为0,说明没有被其他线程持有,Java西南角会将持有该线程设置为当前线程,并将计数器加1<br/>
 * 2、在目标锁对象当计数器部位0的情况下,如果锁对象持有线程是当前线程,那么西南角将其计数器加1,否则需要等待,直至持有线程释放锁<br/>
 * 3、当执行monitorexit时,虚拟机将锁对象计数器减1,为0时表示锁已被释放<br/>
 *
 * @author lqs
 * @date 2022/8/3
 */
public class SynTest {
  public static void main(String[] args) {
    SynTest synTest = new SynTest();
    new Thread(synTest::m1).start();
  }

  public synchronized void m1() {
    System.out.println(Thread.currentThread().getName() + "\t---come in");
    m2();
    System.out.println(Thread.currentThread().getName() + "\t---end");
  }

  public synchronized void m2() {
    System.out.println(Thread.currentThread().getName() + "\t---come in");
    m3();
  }

  public synchronized void m3() {
    System.out.println(Thread.currentThread().getName() + "\t---come in");
  }
}
