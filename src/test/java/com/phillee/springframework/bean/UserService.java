package com.phillee.springframework.bean;

import org.junit.BeforeClass;

/**
 * @Description: 用于测试的对象
 * @Author: PhilLee
 * @Date: 2021/12/10 11:03
 */
public class UserService {

    private String username;

    public UserService(String username) {
        this.username = username;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息" + username);
    }

    @Override
    public String toString() {
        return new StringBuilder("").append("").append(username).toString();
    }
}
