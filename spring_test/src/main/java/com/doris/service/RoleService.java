package com.doris.service;

import com.doris.domain.Role;

import java.util.List;

public interface RoleService {
    public List<Role> findAll();

    void add(Role role);
}
