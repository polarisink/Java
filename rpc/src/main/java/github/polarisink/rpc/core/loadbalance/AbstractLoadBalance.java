package github.polarisink.rpc.core.loadbalance;

import cn.hutool.core.collection.CollUtil;
import github.polarisink.rpc.core.remoting.dto.RpcRequest;

import java.util.List;

/**
 * Abstract class for a load balancing policy
 *
 * @author shuang.kou
 * @createTime 2020年06月21日 07:44:00
 */
public abstract class AbstractLoadBalance implements LoadBalance {
  @Override
  public String selectServiceAddress(List<String> serviceAddresses, RpcRequest rpcRequest) {
    if (CollUtil.isEmpty(serviceAddresses)) {
      return null;
    }
    if (serviceAddresses.size() == 1) {
      return serviceAddresses.get(0);
    }
    return doSelect(serviceAddresses, rpcRequest);
  }

  /**
   * @param serviceAddresses
   * @param rpcRequest
   * @return
   */
  protected abstract String doSelect(List<String> serviceAddresses, RpcRequest rpcRequest);

}
