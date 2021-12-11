package com.phillee.springframework.beans.factory.support;

import com.phillee.springframework.beans.factory.BeanFactory;
import com.phillee.springframework.beans.factory.config.BeanDefinition;

import java.util.Objects;

/**
 * @Description: 抽象类定义模版方法
 * @Author: PhilLee
 * @Date: 2021/12/11 19:33
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) {

        Object bean = getSingleton(name);
        if (Objects.nonNull(bean)) { return bean; }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);

    protected abstract BeanDefinition getBeanDefinition(String beanName);

}
