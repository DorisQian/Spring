package com.doris.dao;

import com.doris.domain.User;

import java.util.List;

public interface UserDao {

    public List<User> findAll();

    Long add(User user);

    public void addRelate(Long userID, Long roleId);

    public void delete(Long userId);

    User login(String username, String password);
}
