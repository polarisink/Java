package github.polarisink.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author aries
 * @date 2022/9/8
 */
public class AtomicIntegerTest {
  public static void main(String[] args) {
    AtomicInteger integer = new AtomicInteger();
    LongAdder longAdder = new LongAdder();
    /**
     *     LongAdder.java
     * 	public void add(long x) {
     * 		//as是striped64中的cells数组属性
     * 		//b是striped64中的base属性
     * 		//v是当前线程hash到的cell中存储的值
     * 		//m是cells的长度减1,hash时作为掩码使用
     * 		//a时当前线程hash到的cell
     *         Cell[] as; long b, v; int m; Cell a;
     * 		/**
     * 		首次首线程(as = cells) != null)一定是false,此时走casBase方法,以CAS的方式更新base值,
     * 		且只有当cas失败时,才会走到if中
     * 		条件1:cells不为空,说明出现过竞争,cell[]已创建
     * 		条件2:cas操作base失败,说明其他线程先一步修改了base正在出现竞争
     *
     *         if ((as = cells) != null || !casBase(b = base, b + x)) {
     * 			//true无竞争 fasle表示竞争激烈,多个线程hash到同一个cell,可能要扩容
     *             boolean uncontended = true;
     * 			/*
     * 			条件1:cells为空,说明正在出现竞争,上面是从条件2过来的,说明!casBase(b = base, b + x))=true
     * 				  会通过调用longAccumulate(x, null, uncontended)新建一个数组,默认长度是2
     * 			条件2:默认会新建一个数组长度为2的数组,m = as.length - 1) < 0 应该不会出现,
     * 			条件3:当前线程所在的cell为空,说明当前线程还没有更新过cell,应初始化一个cell。
     * 				  a = as[getProbe() & m]) == null,如果cell为空,进行一个初始化的处理
     * 			条件4:更新当前线程所在的cell失败,说明现在竞争很激烈,多个线程hash到同一个Cell,应扩容
     * 				  (如果是cell中有一个线程操作,这个时候,通过a.cas(v = a.value, v + x)可以进行处理,返回的结果是true)
     * 			*
     *             if (as == null || (m = as.length - 1) < 0 ||
     * 			    //getProbe( )方法返回的时线程中的threadLocalRandomProbe字段
     * 				//它是通过随机数生成的一个值,对于一个确定的线程这个值是固定的(除非刻意修改它)
     *                 (a = as[getProbe() & m]) == null ||
     *                 !(uncontended = a.cas(v = a.value, v + x)))
     * 				//调用Striped64中的方法处理
     *                 longAccumulate(x, null, uncontended);
     *         }
     */
  }


}
