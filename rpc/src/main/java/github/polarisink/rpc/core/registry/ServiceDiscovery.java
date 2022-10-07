package github.polarisink.rpc.core.registry;

import github.polarisink.rpc.common.extension.Spi;
import github.polarisink.rpc.core.remoting.dto.RpcRequest;

import java.net.InetSocketAddress;

/**
 * service discovery
 *
 * @author shuang.kou
 * @createTime 2020年06月01日 15:16:00
 */
@Spi
public interface ServiceDiscovery {
  /**
   * lookup service by rpcServiceName
   *
   * @param rpcRequest rpc service pojo
   * @return service address
   */
  InetSocketAddress lookupService(RpcRequest rpcRequest);
}
