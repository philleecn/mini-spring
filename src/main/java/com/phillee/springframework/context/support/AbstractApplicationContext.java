package com.phillee.springframework.context.support;

import com.phillee.springframework.beans.BeansException;
import com.phillee.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.phillee.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.phillee.springframework.beans.factory.config.BeanPostProcessor;
import com.phillee.springframework.context.ConfigurableApplicationContext;
import com.phillee.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * @Description: 应用上下文抽象类实现
 * @Author: PhilLee
 * @Date: 2022/1/20 14:39
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {

        // 1， 创建beanFactory，并加载beanDefinition
        refreshBeanFactory();

        // 2, 获取beanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3, 在bean实例化之前，执行beanFactoryPostProcessor(Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);

        // 4. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        // 5， 提前实例化单例bean对象
        beanFactory.preInstantiateSingletons();
    }

    protected abstract void refreshBeanFactory();

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beansOfType = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beansOfType.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beansOfType = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beansOfType.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeansDefinitionNames() {
        return getBeanFactory().getBeansDefinitionNames();
    }
}
