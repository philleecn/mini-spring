package com.phillee.springframework.beans.factory;

/**
 * @Description: 实现此接口的 Bean 对象，会在 BeanFactory 设置属性后作出相应的处理，如：执行自定义初始化，或者仅仅检查是否设置了所有强制属性。
 * @Author: PhilLee
 * @Date: 2022/2/22 22:47
 */
public interface InitializingBean {

    /**
      * @Description: bean 处理属性填充后调用
      * @param
      * @return void
      */
    void afterPropertiesSet() throws Exception;
}
