package com.doris.dao.impl;

import com.doris.dao.UserDao;
import com.doris.domain.User;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {
    private String username;
    private int age;
    private List<String> strList;
    private Map<String, User> userMap;
    private Properties properties;


    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void save() {
//        System.out.println("name:" + username + " age:" + age);
        System.out.println(strList);
        System.out.println(userMap);
        System.out.println(properties);
        System.out.println("test userDao");
    }

//    public UserDaoImpl() {
//        System.out.println("UserDaoImpl创建");
//    }



    public void init() {
        System.out.println("初始化");
    }

    public void destroy() {
        System.out.println("销毁");
    }

}
