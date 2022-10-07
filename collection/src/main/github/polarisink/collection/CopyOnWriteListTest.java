package github.polarisink.collection;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static github.polarisink.collection.Const.list;

/**
 * @author aries
 * @date 2022/9/30
 */
public class CopyOnWriteListTest {

  private static final Integer THREAD_POOL_MAX_SIZE = 10;


  public static void main(String[] args) {
    List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>(list);
    System.out.println("------------初始化完成--------------------------");
    ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_MAX_SIZE);
    // 读写并发测试
    for (int i = 0; i < THREAD_POOL_MAX_SIZE; i++) {
      // 读任务立即执行
      executorService.execute(() -> {
        for (String item : copyOnWriteArrayList) {
          System.out.println(Thread.currentThread().getName() + "数据：" + item);
        }
      });
      final int final1 = i + 10;
      // 写任务立即执行
      executorService.execute(() -> copyOnWriteArrayList.add("写线程添加数据" + final1 + ".............."));
    }

  }
}
