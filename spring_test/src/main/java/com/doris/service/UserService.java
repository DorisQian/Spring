package com.doris.service;

import com.doris.domain.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    void add(User user, Long[] roleIds);

    public void delete(Long userId);

    User login(String username, String password);
}
