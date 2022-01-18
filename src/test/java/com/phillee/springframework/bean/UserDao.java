package com.phillee.springframework.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: PhilLee
 * @Date: 2022/1/18 15:50
 */
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "小傅哥");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    public String queryUserNameByUid(String uId) {
        return hashMap.get(uId);
    }
}
