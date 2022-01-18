package com.phillee.springframework.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description: 定义属性 属性值
 * @Author: PhilLee
 * @Date: 2022/1/18 09:39
 */

@AllArgsConstructor
@Data
public class PropertyValue {

    private final String name;

    private final Object value;

}
