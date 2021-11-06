package com.doris.dao;

import com.doris.domain.Role;

import java.util.List;

public interface RoleDao {
    public List<Role> findAll();

    void save(Role role);

    public List<Role> findByUserId(Long userId);

}
