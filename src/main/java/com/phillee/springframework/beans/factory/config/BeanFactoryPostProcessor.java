package com.phillee.springframework.beans.factory.config;

import com.phillee.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @Description: 满足于在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
 * @Author: PhilLee
 * @Date: 2022/1/20 09:54
 */
public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory);
}
