package github.polarisink.collection;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author aries
 * @date 2022/9/30
 */
public class Const {
  public static final List<String> list = IntStream.rangeClosed(0, 100).mapToObj(String::valueOf).collect(Collectors.toList());

}
