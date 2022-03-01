package com.phillee.springframework.beans.factory.config;

import com.phillee.springframework.beans.BeansException;

/**
 * @Description: 用于修改新实例化 Bean 对象的扩展点
 * @Author: PhilLee
 * @Date: 2022/1/20 12:40
 */
public interface BeanPostProcessor {

    /***
     * @Description: 在 Bean 对象执行初始化方法之前，执行此方法
     * @Param: [java.lang.Object, java.lang.String]
     * @Return: java.lang.Object
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /***
     * @Description: 在 Bean 对象执行初始化方法之后，执行此方法
     * @Param: [java.lang.Object, java.lang.String]
     * @Return: java.lang.Object
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
