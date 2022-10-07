package github.polarisink.rpc.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author aries
 * @date 2022/10/7
 */
@AllArgsConstructor
@Getter
public enum CompressEnum {
  GZIP((byte) 0x01, "gzip");

  private final byte code;
  private final String name;

  public static String getName(byte code) {
    return Arrays.stream(CompressEnum.values()).filter(c -> c.getCode() == code).findFirst().map(c -> c.name).orElse(null);
  }
}
