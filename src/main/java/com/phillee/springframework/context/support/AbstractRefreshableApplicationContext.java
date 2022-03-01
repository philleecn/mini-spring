package com.phillee.springframework.context.support;

import com.phillee.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.phillee.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Description: 获取Bean工厂和加载资源
 * @Author: PhilLee
 * @Date: 2022/1/20 15:19
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
