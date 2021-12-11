package com.phillee.springframework.beans.factory.config;

/**
 * @Description: 获取单例注册的接口
 * @Author: PhilLee
 * @Date: 2021/12/11 19:16
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
