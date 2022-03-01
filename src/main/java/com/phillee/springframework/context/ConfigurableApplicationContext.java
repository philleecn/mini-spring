package com.phillee.springframework.context;

import com.phillee.springframework.beans.BeansException;

/**
 * @Description: 在上下文的实现中完成刷新容器的操作
 * @Author: PhilLee
 * @Date: 2022/1/20 14:36
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /***
     * @Description: 刷新容器
     * @Param: []
     * @Return: void
     */
    void refresh() throws BeansException;
}
