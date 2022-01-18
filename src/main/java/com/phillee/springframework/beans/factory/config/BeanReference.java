package com.phillee.springframework.beans.factory.config;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description:
 * @Author: PhilLee
 * @Date: 2022/1/18 14:40
 */
@AllArgsConstructor
@Data
public class BeanReference {
    private final String beanName;
}
