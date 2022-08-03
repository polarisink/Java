package github.polarisink.cas;

import lombok.val;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lqs
 * @date 2022/8/2
 */
public class CasDemo {
	public static void main(String[] args) {
		val integer = new AtomicInteger();
		integer.incrementAndGet();
	}
}
