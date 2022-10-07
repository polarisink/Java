//package github.polarisink.vt;
//
//import java.time.Duration;
//
///**
// * @author aries
// * @date 2022/9/22
// */
//public final class VirtualThreadsTest {
//  public static void say(String s) {
//    try {
//      for (int i = 0; i < 5; i++) {
//        Thread.sleep(Duration.ofMillis(100));
//        System.out.println(s);
//      }
//    } catch (InterruptedException e) {
//      throw new RuntimeException(e);
//    }
//  }
//
//  public static void main(String[] args) throws InterruptedException {
//    var worldThread = Thread.startVirtualThread(
//        () -> say("world")
//    );
//    say("hello");
//    // 等待虚拟线程结束
//    worldThread.join();
//  }
//}
