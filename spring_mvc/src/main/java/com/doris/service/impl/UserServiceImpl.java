package com.doris.service.impl;

import com.doris.dao.UserDao;
import com.doris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service("UserService")
public class UserServiceImpl implements UserService {

    //@Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        userDao.save();
    }
}
