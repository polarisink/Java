package github.polarisink.rpc.core.remoting.transport.socket;

import github.polarisink.rpc.common.exception.RpcException;
import github.polarisink.rpc.common.extension.ExtensionLoader;
import github.polarisink.rpc.core.registry.ServiceDiscovery;
import github.polarisink.rpc.core.remoting.dto.RpcRequest;
import github.polarisink.rpc.core.remoting.transport.RpcRequestTransport;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 基于 Socket 传输 RpcRequest
 *
 * @author shuang.kou
 * @createTime 2020年05月10日 18:40:00
 */
@AllArgsConstructor
@Slf4j
public class SocketRpcClient implements RpcRequestTransport {
  private final ServiceDiscovery serviceDiscovery;

  public SocketRpcClient() {
    this.serviceDiscovery = ExtensionLoader.getExtensionLoader(ServiceDiscovery.class).getExtension("zk");
  }

  @Override
  public Object sendRpcRequest(RpcRequest rpcRequest) {
    InetSocketAddress inetSocketAddress = serviceDiscovery.lookupService(rpcRequest);
    try (Socket socket = new Socket()) {
      socket.connect(inetSocketAddress);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
      // Send data to the server through the output stream
      objectOutputStream.writeObject(rpcRequest);
      ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
      // Read RpcResponse from the input stream
      return objectInputStream.readObject();
    } catch (IOException | ClassNotFoundException e) {
      throw new RpcException("调用服务失败:", e);
    }
  }
}
