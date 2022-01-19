package com.phillee.springframework.core.io;

import cn.hutool.core.lang.Assert;
import com.phillee.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: 通过 ClassLoader 读取ClassPath 下的文件信息
 * @Author: PhilLee
 * @Date: 2022/1/18 18:30
 */
public class ClassPathResource implements Resource {

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must be not null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream resourceInputStream = classLoader.getResourceAsStream(path);
        if (resourceInputStream == null) {
            throw new FileNotFoundException(this.path + "cannot open this file 'cause doesn't exist");
        }

        return resourceInputStream;
    }

}
