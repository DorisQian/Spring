package com.doris.mapper;

import com.doris.domain.User;

import java.util.List;

public interface UserMapper {
    public void save(User user);
    public User findById(Integer id);
}
