package com.phillee.springframework.context.support;

import com.phillee.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.phillee.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Objects;

/**
 * @Description: 上下文对配置信息的加载
 * @Author: PhilLee
 * @Date: 2022/2/21 23:03
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    /***
     * @Description: 使用 XmlBeanDefinitionReader 类，处理了关于 XML 文件配置信息的操作
     * @Param: [com.phillee.springframework.beans.factory.support.DefaultListableBeanFactory]
     * @Return: void
     */
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (Objects.nonNull(configLocations)) beanDefinitionReader.loadBeanDefinitions(configLocations);
    }

    /***
     * @Description: 从入口上下文类，拿到配置信息的地址描述
     * @Param: []
     * @Return: java.lang.String[]
     */
    protected abstract String[] getConfigLocations();
}
