package github.polarisink.rpc.core.remoting.transport;

import github.polarisink.rpc.common.extension.Spi;
import github.polarisink.rpc.core.remoting.dto.RpcRequest;

/**
 * send RpcRequest。
 *
 * @author shuang.kou
 * @createTime 2020年05月29日 13:26:00
 */
@Spi
public interface RpcRequestTransport {
  /**
   * send rpc request to server and get result
   *
   * @param rpcRequest message body
   * @return data from server
   */
  Object sendRpcRequest(RpcRequest rpcRequest);
}
