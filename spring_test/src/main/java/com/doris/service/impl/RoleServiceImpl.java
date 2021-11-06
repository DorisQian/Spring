package com.doris.service.impl;

import com.doris.dao.RoleDao;
import com.doris.domain.Role;
import com.doris.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> findAll() {
       return roleDao.findAll();
    }

    public void add(Role role) {
        roleDao.save(role);
    }
}
