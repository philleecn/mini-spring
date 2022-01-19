package com.phillee.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: 资源加载接口
 * @Author: PhilLee
 * @Date: 2022/1/18 18:28
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
