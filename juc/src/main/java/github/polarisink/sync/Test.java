package github.polarisink.sync;

interface Food {
  /**
   * 做面
   *
   * @throws InterruptedException
   */
  void makeNoodles() throws InterruptedException;

  /**
   * 吃面
   *
   * @throws InterruptedException
   */
  void eatNoodles() throws InterruptedException;
}

/**
 * @author hzsk
 */
public class Test {

  public static void main(String[] args) {

    Food noodles = new RegularNoodles();
    new Thread(() -> {
      try {
        for (int i = 0; i < 10; i++) {
          noodles.makeNoodles();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }, "厨师A").start();
    new Thread(() -> {
      try {
        for (int i = 0; i < 10; i++) {
          noodles.makeNoodles();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }, "厨师B").start();
    new Thread(() -> {
      try {
        for (int i = 0; i < 10; i++) {
          noodles.eatNoodles();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }, "食客甲").start();

    new Thread(() -> {
      try {
        for (int i = 0; i < 10; i++) {
          noodles.eatNoodles();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }, "食客乙").start();
  }
}

/**
 * 普通面
 */
class RegularNoodles implements Food {

  /**
   * 面的数量
   */
  private int num = 0;

  /**
   * 做面方法
   */
  @Override
  public synchronized void makeNoodles() throws InterruptedException {
    //如果面的数量不为0，则等待食客吃完面再做面
    if (num != 0) {
      this.wait();
    }
    num++;
    System.out.println(Thread.currentThread().getName() + "做好了一份面，当前有" + num + "份面");
    //面做好后，唤醒食客来吃
    this.notifyAll();
  }

  /**
   * 吃面方法
   */
  @Override
  public synchronized void eatNoodles() throws InterruptedException {
    //如果面的数量为0，则等待厨师做完面再吃面
    if (num == 0) {
      this.wait();
    }
    num--;
    System.out.println(Thread.currentThread().getName() + "吃了一份面，当前有" + num + "份面");
    //吃完则唤醒厨师来做面
    this.notifyAll();
  }
}

/**
 * if改while可以不再虚假唤醒
 * 手擀面
 */
class HandRolled implements Food {

  /**
   * 面的数量
   */
  private int num = 0;

  /**
   * 做面方法
   */
  @Override
  public synchronized void makeNoodles() throws InterruptedException {
    //如果面的数量不为0，则等待食客吃完面再做面
    while (num != 0) {
      this.wait();
    }
    num++;
    System.out.println(Thread.currentThread().getName() + "做好了一份面，当前有" + num + "份面");
    //面做好后，唤醒食客来吃
    this.notifyAll();
  }

  /**
   * 吃面方法
   */
  @Override
  public synchronized void eatNoodles() throws InterruptedException {
    //如果面的数量为0，则等待厨师做完面再吃面
    while (num == 0) {
      this.wait();
    }
    num--;
    System.out.println(Thread.currentThread().getName() + "吃了一份面，当前有" + num + "份面");
    //吃完则唤醒厨师来做面
    this.notifyAll();
  }
}