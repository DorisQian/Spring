package com.doris.service.impl;

import com.doris.dao.UserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.doris.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    //有参构造
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

    public void save() {
        userDao.save();
    }
}
