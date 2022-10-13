package github.polarisink.collection;

import cn.hutool.core.util.StrUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author aries
 * @date 2022/9/30
 */
public class HashMapTest {
  public static void main(String[] args) {
    Random rand = new Random(47);
    Map<Integer, Integer> map = new HashMap<>(100);
    IntStream.rangeClosed(0, 100).forEach(i -> map.put(rand.nextInt(100), rand.nextInt(100)));
    map.forEach((k, v) -> System.out.println(StrUtil.format("key:{}, value:{}", k, v)));
  }

}
