package github.polarisink.rpc.core.compress;

import github.polarisink.rpc.common.extension.Spi;

/**
 * @author wangtao .
 * @createTime on 2020/10/3
 */

@Spi
public interface Compress {

  byte[] compress(byte[] bytes);


  byte[] decompress(byte[] bytes);
}
