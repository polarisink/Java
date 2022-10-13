package github.polarisink.interrupt;

/**
 * @author lqs
 * @date 2022/8/11
 */
public class InterruptTest3 {
  public static void main(String[] args) {
    //调用两次后一个一定为false
    System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());
    System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());
    System.out.println("-------1");
    Thread.currentThread().interrupt();
    System.out.println("-------2");
    System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());
    System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());
  }
}
