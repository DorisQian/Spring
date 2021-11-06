package com.doris.service.impl;

import com.doris.dao.RoleDao;
import com.doris.dao.UserDao;
import com.doris.domain.Role;
import com.doris.domain.User;
import com.doris.service.UserService;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private RoleDao roleDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<User> findAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            List<Role> roles = roleDao.findByUserId(user.getId());
            user.setRoleList(roles);
        }
        return users;
    }

    public void add(User user, Long[] roleIds) {
        Long userId = userDao.add(user);
        for (Long roleId : roleIds) {
            userDao.addRelate(userId, roleId);
        }
    }

    public void delete(Long userId) {
        userDao.delete(userId);
    }
}
