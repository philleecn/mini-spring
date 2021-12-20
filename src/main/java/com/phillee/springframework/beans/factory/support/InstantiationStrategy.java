package com.phillee.springframework.beans.factory.support;

import com.phillee.springframework.beans.BeansException;
import com.phillee.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Description: 定义实例化策略接口
 * @Author: PhilLee
 * @Date: 2021/12/16 10:51
 */
public interface InstantiationStrategy {

    /**
     * @Description: 使用Constructor的目的就是为了拿到符合入参信息相对应的构造函数
     * @Param: [com.phillee.springframework.beans.factory.config.BeanDefinition, java.lang.String, java.lang.reflect.Constructor, java.lang.Object[]]
     * @Return: java.lang.Object
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException;

}
