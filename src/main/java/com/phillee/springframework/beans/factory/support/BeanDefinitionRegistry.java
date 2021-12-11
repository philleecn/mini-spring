package com.phillee.springframework.beans.factory.support;

import com.phillee.springframework.beans.factory.config.BeanDefinition;

/**
 * @Description:
 * @Author: PhilLee
 * @Date: 2021/12/11 20:33
 */
public interface BeanDefinitionRegistry {

    /**
     * @Description: 向注册表中注册 BeanDefinition
     * @Param: [java.lang.String, com.phillee.springframework.beans.factory.config.BeanDefinition]
     * @Return: void
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
