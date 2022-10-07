package github.polarisink.rpc.core.registry.zk;

import cn.hutool.core.collection.CollUtil;
import github.polarisink.rpc.common.enums.RpcErrorMessageEnum;
import github.polarisink.rpc.common.exception.RpcException;
import github.polarisink.rpc.common.extension.ExtensionLoader;
import github.polarisink.rpc.core.loadbalance.LoadBalance;
import github.polarisink.rpc.core.registry.ServiceDiscovery;
import github.polarisink.rpc.core.registry.zk.util.CuratorUtils;
import github.polarisink.rpc.core.remoting.dto.RpcRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * service discovery based on zookeeper
 *
 * @author shuang.kou
 * @createTime 2020年06月01日 15:16:00
 */
@Slf4j
public class ZkServiceDiscoveryImpl implements ServiceDiscovery {
  private final LoadBalance loadBalance;

  public ZkServiceDiscoveryImpl() {
    this.loadBalance = ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension("loadBalance");
  }

  @Override
  public InetSocketAddress lookupService(RpcRequest rpcRequest) {
    String rpcServiceName = rpcRequest.getRpcServiceName();
    CuratorFramework zkClient = CuratorUtils.getZkClient();
    List<String> serviceUrlList = CuratorUtils.getChildrenNodes(zkClient, rpcServiceName);
    if (CollUtil.isEmpty(serviceUrlList)) {
      throw new RpcException(RpcErrorMessageEnum.SERVICE_CAN_NOT_BE_FOUND, rpcServiceName);
    }
    // load balancing
    String targetServiceUrl = loadBalance.selectServiceAddress(serviceUrlList, rpcRequest);
    log.info("Successfully found the service address:[{}]", targetServiceUrl);
    String[] socketAddressArray = targetServiceUrl.split(":");
    String host = socketAddressArray[0];
    int port = Integer.parseInt(socketAddressArray[1]);
    return new InetSocketAddress(host, port);
  }
}
