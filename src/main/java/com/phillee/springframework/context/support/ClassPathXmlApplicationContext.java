package com.phillee.springframework.context.support;

import com.phillee.springframework.beans.BeansException;

/**
 * @Description: 具体对外给用户提供的应用上下文方法
 * @Author: PhilLee
 * @Date: 2022/2/21 23:18
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    /**
     * @param configLocations
     * @return null
     * @Description: 从 XML 中加载 BeanDefinition，并刷新上下文
     */
    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }

    /**
     * @param configLocations
     * @Description: 从 XML 中加载 BeanDefinition，并刷新上下文
     */
    public ClassPathXmlApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
