package com.phillee.springframework.bean;

/**
 * @Description: 用于测试的对象
 * @Author: PhilLee
 * @Date: 2021/12/10 11:03
 */
public class UserService {

    public void queryUserInfo(String msg) {
        System.out.println("第" + msg +"次被调用");
    }

}
