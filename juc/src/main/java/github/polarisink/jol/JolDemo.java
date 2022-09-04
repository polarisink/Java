package github.polarisink.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author lqs
 * @date 2022/9/4
 */
public class JolDemo {
  public static void main(String[] args) {
    //System.out.println(VM.current().details());
    Object o = new Object();
    System.out.println(ClassLayout.parseInstance(o).toPrintable());
  }
}

class Customer {
  int id;
  boolean flag = false;
}
