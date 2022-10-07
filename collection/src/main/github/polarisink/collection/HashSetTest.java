package github.polarisink.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author aries
 * @date 2022/9/30
 */
public class HashSetTest {
  public static void main(String[] args) {
    Set<Integer> set = Set.of(1, 5, 9, 4, 3, -1);
    System.out.println(set);
    HashSet<Integer> hashSet = new HashSet<>(set);
    hashSet.add(11);
    //hash计算之后有了顺序
    System.out.println(hashSet);
  }
}
