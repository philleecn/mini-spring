package com.phillee.springframework.beans;

/**
 * @Description:
 * @Author: PhilLee
 * @Date: 2021/12/11 20:20
 */
public class BeansException extends RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
