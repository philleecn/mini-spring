package com.phillee.springframework.beans.factory.support;

import com.phillee.springframework.beans.BeansException;
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

    /**
     * 使用Bean名称查询BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
//    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     */
//    String[] getBeanDefinitionNames();
}
