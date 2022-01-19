package com.phillee.springframework.core.io;

import cn.hutool.core.lang.Assert;

import javax.print.DocFlavor;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description:
 * @Author: PhilLee
 * @Date: 2022/1/18 20:15
 */
public class DefaultResourceLoader implements ResourceLoader {

    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }

    }
}
