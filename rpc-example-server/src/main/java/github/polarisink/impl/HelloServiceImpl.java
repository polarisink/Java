package github.polarisink.impl;

import github.polarisink.api.Hello;
import github.polarisink.api.HelloService;
import github.polarisink.rpc.core.annotation.RpcService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author shuang.kou
 * @createTime 2020年05月10日 07:52:00
 */
@Slf4j
@RpcService(group = "test1", version = "version1")
public class HelloServiceImpl implements HelloService {

    static {
        System.out.println("test flow");
        System.out.println("test flow2");
        System.out.println("test flow3");
        System.out.println("test flow4");
        System.out.println("test flow5");
    }

    @Override
    public String hello(Hello hello) {
        log.info("HelloServiceImpl收到: {}.", hello.getMessage());
        String result = "Hello description is " + hello.getDescription();
        log.info("HelloServiceImpl返回: {}.", result);
        return result;
    }
}
