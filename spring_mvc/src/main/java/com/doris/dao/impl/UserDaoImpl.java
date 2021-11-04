package com.doris.dao.impl;

import com.doris.dao.UserDao;
import org.springframework.stereotype.Repository;

//@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("dao impl save");
    }
}
