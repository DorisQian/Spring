package com.doris.factory;

import com.doris.dao.UserDao;
import com.doris.dao.impl.UserDaoImpl;

public class DynamicFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
