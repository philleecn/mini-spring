package com.phillee.springframework.bean;

import lombok.Data;
import lombok.ToString;
import org.junit.BeforeClass;

/**
 * @Description: 用于测试的对象
 * @Author: PhilLee
 * @Date: 2021/12/10 11:03
 */
@Data
@ToString
public class UserService {

    private String uId;

    private UserDao userDao;

    private String company;

    private String location;

    public String queryUserInfo() {
        return userDao.queryUserNameByUid(uId);
    }

}
