package github.polarisink.rpc.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author hzsk
 */

@AllArgsConstructor
@Getter
public enum RpcConfigEnum {

  RPC_CONFIG_PATH("rpc.properties"), ZK_ADDRESS("rpc.zookeeper.address");

  private final String propertyValue;

}
