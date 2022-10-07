package github.polarisink.rpc.core.loadbalance;

import github.polarisink.rpc.common.extension.Spi;
import github.polarisink.rpc.core.remoting.dto.RpcRequest;

import java.util.List;

/**
 * Interface to the load balancing policy
 *
 * @author shuang.kou
 * @createTime 2020年06月21日 07:44:00
 */
@Spi
public interface LoadBalance {
  /**
   * Choose one from the list of existing service addresses list
   *
   * @param serviceUrlList Service address list
   * @param rpcRequest
   * @return target service address
   */
  String selectServiceAddress(List<String> serviceUrlList, RpcRequest rpcRequest);
}
