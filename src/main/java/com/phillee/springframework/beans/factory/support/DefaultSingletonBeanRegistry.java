package com.phillee.springframework.beans.factory.support;

import com.phillee.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: SingletonBeanRegistry的实现类
 * @Author: PhilLee
 * @Date: 2021/12/11 19:25
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected Object addSingleton(String beanName, Object singletonObject) {
        return singletonObjects.put(beanName, singletonObject);
    }
}
