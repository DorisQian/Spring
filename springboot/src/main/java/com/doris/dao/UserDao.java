package com.doris.dao;

import com.doris.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select * from sys_user where id=#{id}")
    public User getById(Integer id);
}
