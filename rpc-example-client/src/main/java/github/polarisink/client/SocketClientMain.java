package github.polarisink.client;


import github.polarisink.api.Hello;
import github.polarisink.api.HelloService;
import github.polarisink.rpc.core.config.RpcServiceConfig;
import github.polarisink.rpc.core.proxy.RpcClientProxy;
import github.polarisink.rpc.core.remoting.transport.RpcRequestTransport;
import github.polarisink.rpc.core.remoting.transport.socket.SocketRpcClient;

/**
 * @author shuang.kou
 * @createTime 2020年05月10日 07:25:00
 */
public class SocketClientMain {
    public static void main(String[] args) {
        RpcRequestTransport rpcRequestTransport = new SocketRpcClient();
        RpcServiceConfig rpcServiceConfig = new RpcServiceConfig();
        RpcClientProxy rpcClientProxy = new RpcClientProxy(rpcRequestTransport, rpcServiceConfig);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        String hello = helloService.hello(new Hello("111", "222"));
        System.out.println(hello);
    }
}
