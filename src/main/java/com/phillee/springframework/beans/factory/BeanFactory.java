package com.phillee.springframework.beans.factory;

import com.phillee.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: Bean工厂：注册Bean、获取Bean
 * @Author: PhilLee
 * @Date: 2021/12/10 10:49
 */
public interface BeanFactory {

    //获取bean
    public Object getBean(String name);

}
